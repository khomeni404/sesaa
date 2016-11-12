package net.softengine.security;

import net.softengine.constant.SecurityConstants;
import net.softengine.security.service.SecurityService;
import net.softengine.security.service.UserDetailsService;
import net.softengine.util.ActionUtil;
import net.softengine.util.PasswordValidator;
import com.google.gson.Gson;
import net.softengine.security.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/security/")
public class SecurityController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private SecurityService securityService;

    @RequestMapping(method = RequestMethod.GET, value = "/home.se")
    public ModelAndView home() {
        Map<String, Object> map = ActionUtil.getModelMap("Security Home");
        return new ModelAndView("/security/home_security", map);
    }


    //=======USER=========START================================================
    @RequestMapping(method = RequestMethod.GET, value = "/createUser.se")
    public ModelAndView createUser(@RequestParam("errMsg") String errMsg) {
        Map<String, Object> map = ActionUtil.getModelMap("Create User");
        map.put("errMsg", errMsg);
        List<User> users = userDetailsService.getAllUsers();
        map.put("userList", users);

        return new ModelAndView("/security/user_create", map);

    }

    //Ajax Call
    @RequestMapping(value = "/checkDuplicateUser.se", method = RequestMethod.GET)
    public
    @ResponseBody
    String checkDuplicateUser(@RequestParam("username") String username) {
        User user = userDetailsService.getUser(username);
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<String, Object>();
        if (user != null) {
            map.put("msg", "Yes");
            //map.put("name", user.getToken().getUserDetails().getName());
        } else {
            map.put("msg", "No");
        }
        String json = gson.toJson(map);
        return json;
    }

    @RequestMapping(value = "/saveUser.se", method = RequestMethod.GET)
    public
    @ResponseBody
    String saveUser(@RequestParam("username") String username,
                    @RequestParam("password") String password,
                    @RequestParam("confirmPassword") String confirmPassword,
                    @RequestParam("userType") String userType) {
        Gson gson = new Gson();
        Map<String, Object> map = new HashMap<String, Object>();
        User userDuplicate = userDetailsService.findUserByUserCode(username);
        if (userDuplicate != null) {
            map.put("success", "no");
            // map.put("msg", "This username already taken by " + userDuplicate.getToken().getUserDetails().getName());
            String json = gson.toJson(map);
            return json;
        } else {
            if (password.equals(confirmPassword)) {
                Token userToken = new Token();
                userToken.setUsername(username);
                userToken.setPassword(password);
                userDetailsService.saveUser(userToken, userType);
                map.put("success", "yes");
                map.put("msg", "User Saved Successfully");
                String json = gson.toJson(map);
                return json;
            } else {
                map.put("success", "no");
                map.put("msg", "Password doesn't match");
                String json = gson.toJson(map);
                return json;
            }
        }
    }


    @RequestMapping(method = RequestMethod.GET, value = "/editPassword.se")
    public ModelAndView editPassword(@RequestParam(required = false) String message) {
        Map<String, Object> updateUserMap = ActionUtil.getModelMap("Change Password");
        updateUserMap.put("message", message);
        User user = SessionUtil.getSessionUser();
        updateUserMap.put("user", user);
            return new ModelAndView("/security/change_password", updateUserMap);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updatePassword.se")
    public ModelAndView updatePassword(@RequestParam String passOld,
                                       @RequestParam String passNew,
                                       @RequestParam String passNewRe) {
        User user = SessionUtil.getSessionUser();
        Token token = user.getToken();
        String oldPass = token.getDecPassword();
        if (!oldPass.equals(passOld)) {
            return new ModelAndView("redirect:/security/editPassword.se?message=Old Password Doesn't match.");
        } else if (!passNew.equals(passNewRe)) {
            return new ModelAndView("redirect:/security/editPassword.se?message=New and Confirm password Doesn't match.");
        } else {
            PasswordValidator validator = new PasswordValidator();
            boolean validPass = validator.validate(passNew);
            if (validPass) {
                token.setPassword(passNew);
                boolean changed = securityService.update(token);
                if (changed) {
                    return new ModelAndView("redirect:/security/editPassword.se?message=Password Changed Successfully.");
                } else {
                    return new ModelAndView("redirect:/security/editPassword.se?message=Password can't be changed.");
                }
            } else {
                return new ModelAndView("redirect:/security/editPassword.se?message=Password must contain 6-20 character, at least one Uppercase, one Lowercase, one numeric and One Special character.");
            }
        }


    }


    @RequestMapping(method = RequestMethod.GET, value = "/activateUser.se")
    public ModelAndView activateUser(@RequestParam Long id,
                                     @RequestParam Integer active) {
        User user = userDetailsService.getUser(id);
        user.setActive(active == 1);
        userDetailsService.updateUser(user);
        return new ModelAndView("redirect:/admin/customerList.se");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/userProfile.se")
    public ModelAndView userProfile(@RequestParam("id") Long id) {
        Map<String, Object> map = ActionUtil.getModelMap("User Profile");
        User user;
        if (id == 0L) {
            //user = new CurrentUserCredentials().user;
            //id = user.getAuthorizeId();
        } else {
            user = userDetailsService.getUser(id);
        }
//        map.put("user", user);
//        map.put("details", user.getToken().getUserDetails());

        return new ModelAndView("/hrm/user_profile", map);
    }

    @RequestMapping(value = "/updateUser.se", method = RequestMethod.GET)
    public
    @ResponseBody
    String updateUser(@RequestParam("password") String password,
                      @RequestParam("id") Long id) {
        Gson gson = new Gson();
        Map<String, Object> map = ActionUtil.getModelMap("Update User");
        User user = userDetailsService.getUser(id);
        Token token = user.getToken();
        if (!password.equals("")) {
            try {
                token.setPassword(password);
                userDetailsService.updateToken(token);
                map.put("success", "yes");
                map.put("msg", "Update Password Successfully !");
            } catch (Exception ex) {
                map.put("success", "no");
                map.put("msg", "Password Can't be changed !");
            }
        } else {
            map.put("success", "yes");
            map.put("msg", "Password kept as before !");
        }

        String json = gson.toJson(map);
        return json;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/userList.se")
    public ModelAndView userList() {
        System.out.println("userList");
        Map<String, Object> userListMap =  ActionUtil.getModelMap("User List");
        return new ModelAndView("security/user_list", userListMap);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/deleteUser.se")
    public ModelAndView deleteUser(@RequestParam("id") Long id) {
        userDetailsService.delete(userDetailsService.getUser(id));
        return new ModelAndView("redirect:/security/createUser.se?errMsg=");

    }

    //=======USER=========END================================================


    //========Module Start==============================================
    @RequestMapping(method = RequestMethod.GET, value = "/componentList.se")
    public ModelAndView componentList(@RequestParam("msg") String msg) {
        Map<String, Object> map = ActionUtil.getModelMap("Module");
        List<Module> componentList = securityService.findAllModules();
        map.put("componentList", componentList);
        map.put("msg", msg);
        return new ModelAndView("/security/component", map);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveModule.se")
    public ModelAndView saveModule(@RequestParam("componentName") String componentName, @RequestParam("description") String description) {
        Map<String, Object> saveModuleMap = ActionUtil.getModelMap(null);
        Module componentDuplicate = securityService.getModuleByName(componentName);
        if (componentDuplicate != null) {
            saveModuleMap.put("msg", "Module already exists");
            saveModuleMap.put("PageTitle", "Module");
            return new ModelAndView("redirect:/security/componentList.se", saveModuleMap);
        } else {
            Module component = new Module();
            component.setName(componentName);
            component.setDescription(description);
            securityService.save(component);
            saveModuleMap.put("PageTitle", "Create Module");
            saveModuleMap.put("msg", "Module Saved Successfully !!");
            return new ModelAndView("redirect:/security/componentList.se", saveModuleMap);

        }

    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateModule.se")
    public ModelAndView updateModule(@RequestParam("id") Long id,
                                     @RequestParam("name") String name,
                                     @RequestParam("desc") String desc) {
        Map<String, Object> map = ActionUtil.getModelMap("Module");

        Module component = securityService.getModule(id);
        component.setName(name);
        component.setDescription(desc);

        securityService.update(component);
        map.put("msg", "Updated Successfully !!");
        return new ModelAndView("redirect:/security/componentList.se", map);

    }


    @RequestMapping(method = RequestMethod.GET, value = "/deleteModule.se")
    public ModelAndView deleteModule(@RequestParam("id") Long id) {
        Map<String, Object> map = ActionUtil.getModelMap("Module");

        Authority authority = securityService.getAuthority(id);

        if (securityService.delete(authority)) {
            map.put("msg", "Authority Deleted Successfully !!");
            return new ModelAndView("redirect:/security/componentList.se", map);
        } else {
            map.put("msg", "Authority Can't be deleted");
            return new ModelAndView("redirect:/security/componentList.se", map);
        }
    }


    //========Authority Start==============================================
    @RequestMapping(method = RequestMethod.GET, value = "/createAuthority.se")
    public ModelAndView createAuthority(@RequestParam(required = false) String msg) {
        Map<String, Object> map = ActionUtil.getModelMap("Module");
        map.put("PageTitle", "Authority");
        map.put("DashboardLink", SecurityConstants.DASHBOARD_LINK);
        map.put("msg", msg);
        List<Authority> authorityList = securityService.findAllAuthority();
        map.put("authorityList", authorityList);
        return new ModelAndView("/security/authority_create", map);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/saveAuthority.se")
    public ModelAndView saveAuthority(@RequestParam("name") String authorityName,
                                      @RequestParam("desc") String desc) {
        Map<String, String> map = new HashMap<String, String>();
        Authority authorityDuplicate = securityService.findByAuthorityName(authorityName);

        if (authorityDuplicate != null) {
            map.put("msg", "Authority already exists!!!");
            return new ModelAndView("redirect:/security/createAuthority.se", map);
        } else {
            Authority authority = new Authority();
            authority.setName(authorityName);
            authority.setDescription(desc);

            securityService.save(authority);
            map.put("msg", "Authority Saved Successfully !!");
            return new ModelAndView("redirect:/security/createAuthority.se", map);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateAuthority.se")
    public ModelAndView updateAuthority(@RequestParam("id") Long id,
                                        @RequestParam("name") String name,
                                        @RequestParam("desc") String desc) {
        Map<String, String> map = new HashMap<String, String>();

        Authority authority = securityService.getAuthority(id);
        authority.setName(name);
        authority.setDescription(desc);

        securityService.update(authority);
        map.put("result", "Updated Successfully !!");
        return new ModelAndView("redirect:/security/authorityList.se", map);

    }


    @RequestMapping(method = RequestMethod.GET, value = "/deleteAuthority.se")
    public ModelAndView deleteAuthority(@RequestParam("id") Long id) {
        Map<String, String> map = new HashMap<String, String>();

        Authority authority = securityService.getAuthority(id);

        if (securityService.delete(authority)) {
            map.put("result", "Authority Deleted Successfully !!");
            return new ModelAndView("redirect:/security/authorityList.se", map);
        } else {
            map.put("result", "Authority Can't be deleted");
            return new ModelAndView("redirect:/security/authorityList.se", map);
        }
    }

    //======== Authorized Group Start==============================================
    @RequestMapping(method = RequestMethod.GET, value = "/createGroup.se")
    public ModelAndView createGroup(@RequestParam(required = false) String msg) {
        Map<String, Object> map = ActionUtil.getModelMap("Module");
        map.put("PageTitle", "User Group");
        map.put("DashboardLink", SecurityConstants.DASHBOARD_LINK);
        map.put("msg", msg);

        List<Group> groupsList = securityService.findAllGroup();
        map.put("groupsList", groupsList);
        return new ModelAndView("/security/group_create", map);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveGroup.se")
    public ModelAndView saveGroup(@RequestParam String name,
                                  @RequestParam String desc) {

        Map<String, String> map = new HashMap<String, String>();
        Group duplicateGroup = securityService.getGroup(name);

        if (duplicateGroup != null) {
            map.put("msg", "Group already exists!!!");
            return new ModelAndView("redirect:/security/createGroup.se", map);
        } else {
            Group group = new Group();
            group.setName(name);
            group.setDescription(desc);

            securityService.save(group);

            map.put("msg", "Authorized Group is saved successfully!!!");

            return new ModelAndView("redirect:/security/createGroup.se", map);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateGroup.se")
    public ModelAndView updateUserGroup(@RequestParam("id") Long id,
                                        @RequestParam("name") String name,
                                        @RequestParam("desc") String desc) {
        Map<String, String> map = new HashMap<String, String>();

        Group group = securityService.getGroup(id);
        group.setName(name);
        group.setDescription(desc);

        securityService.update(group);
        map.put("msg", "Updated Successfully !!");
        map.put("PageTitle", "Group");
        return new ModelAndView("redirect:/security/authorizedGroupsList.se", map);

    }


    @RequestMapping(method = RequestMethod.GET, value = "/deleteGroup.se")
    public ModelAndView deleteUserGroup(@RequestParam("id") Long id) {
        Map<String, String> map = new HashMap<String, String>();

        Group group = securityService.getGroup(id);

        if (securityService.delete(group)) {
            map.put("msg", "Group Deleted Successfully !!");
            return new ModelAndView("redirect:/security/authorizedGroupsList.se", map);
        } else {
            map.put("msg", "Group Can't be deleted");
            return new ModelAndView("redirect:/security/authorizedGroupsList.se", map);
        }

    }

    //========Operation Start==============================================
    @RequestMapping(method = RequestMethod.GET, value = "/createOperation.se")
    public ModelAndView createOperation(@RequestParam(required = false) String message) {
        Map<String, Object> map = ActionUtil.getModelMap("Module");
        map.put("PageTitle", "Operation");
        map.put("DashboardLink", SecurityConstants.DASHBOARD_LINK);
        map.put("message", message);
        List<Module> moduleList = securityService.findAllModules();
        map.put("moduleList", moduleList);

        return new ModelAndView("/security/operation_create", map);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveOperation.se")
    public ModelAndView saveOperation(@RequestParam String description,
                                      @RequestParam String name,
                                      @RequestParam Long moduleId) {
        Map<String, String> map = new HashMap<String, String>();
        Operation operationOperationDuplicate = securityService.findOperationByName(name);
        if (operationOperationDuplicate != null) {
            map.put("message", "Operation already exists");
            return new ModelAndView("redirect:/security/createOperation.se", map);

        } else {
            Module module = securityService.getModuleById(moduleId);
            Operation operation = new Operation();
            operation.setName(name);
            operation.setDescription(description);
            operation.setModule(module);
            boolean saved = securityService.save(operation);
            if (saved) {
                map.put("message", "Operation saved successfully !");
                return new ModelAndView("redirect:/security/createOperation.se", map);
            } else {
                map.put("message", "Operation can't be saved !");
                return new ModelAndView("redirect:/security/createOperation.se", map);
            }

        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/operationList.se")
    public ModelAndView operationList() {
        Map<String, Object> map = ActionUtil.getModelMap("Module");
        map.put("PageTitle", "Operation");
        map.put("DashboardLink", SecurityConstants.DASHBOARD_LINK);
        List<Module> moduleList = securityService.findAllModules();
        map.put("moduleList", moduleList);

        return new ModelAndView("/security/operation_list", map);
    }

    // Assigning Operation
    @RequestMapping(method = RequestMethod.GET, value = "/assigningOperations.se")
    public ModelAndView assigningOperations() {
        Map<String, Object> map = ActionUtil.getModelMap("Module");
        map.put("PageTitle", "Assigning Operation");
        map.put("DashboardLink", SecurityConstants.DASHBOARD_LINK);
        List<Module> moduleList = securityService.findAllModules();
        map.put("moduleList", moduleList);
        List<Authority> authorityList = securityService.findAllAuthority();
        map.put("authorityList", authorityList);

        return new ModelAndView("/security/assigning_operations", map);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateAuthorityOperations.se")
    public ModelAndView updateAuthorityOperations(@RequestParam Long authId,
                                                  @RequestParam(required = false) String operationIds) {
        Map<String, Object> map = new HashMap<>();
        map.put("PageTitle", "Assigning Operation");

        boolean assigned = securityService.updateAuthorityOperations(authId, operationIds);

        return new ModelAndView("redirect:/security/assigningOperations.se", map);
    }

    //Assigning Authorities
    @RequestMapping(method = RequestMethod.GET, value = "/assigningAuthorities.se")
    public ModelAndView assigningAuthorities() {
        Map<String, Object> map = new HashMap<>();
        map.put("PageTitle", "Assigning Operation");
        map.put("DashboardLink", SecurityConstants.DASHBOARD_LINK);
        List<Authority> authorityList = securityService.findAllAuthority();
        map.put("authorityList", authorityList);
        List<Group> groupList = securityService.findAllGroup();
        map.put("groupList", groupList);

        return new ModelAndView("/security/assigning_authorities", map);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateGroupAuthorities.se")
    public ModelAndView updateGroupAuthorities(@RequestParam Long groupId,
                                               @RequestParam(required = false) String authIds) {
        Map<String, Object> map = new HashMap<>();
        map.put("PageTitle", "Assigning Authorities");

        boolean assigned = securityService.updateGroupAuthorities(groupId, authIds);

        return new ModelAndView("redirect:/security/assigningAuthorities.se", map);
    }


    //Assigning Groups
    @RequestMapping(method = RequestMethod.GET, value = "/assigningGroups.se")
    public ModelAndView assigningGroups() {
        Map<String, Object> map = new HashMap<>();
        map.put("PageTitle", "Assigning Operation");
        map.put("DashboardLink", SecurityConstants.DASHBOARD_LINK);
        List<Group> groupList = securityService.findAllGroup();
        map.put("groupList", groupList);
        List<User> userList = userDetailsService.getAllUsers();
        map.put("userList", userList);

        return new ModelAndView("/security/assigning_groups", map);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateUserGroups.se")
    public ModelAndView updateUserGroups(@RequestParam Long userId,
                                         @RequestParam(required = false) String groupIds) {
        Map<String, Object> map = new HashMap<>();
        map.put("PageTitle", "Assigning Group");

        boolean assigned = securityService.updateUserGroups(userId, groupIds);

        return new ModelAndView("redirect:/security/assigningGroups.se", map);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/loginLogList.se")
    public ModelAndView loginLogList() {
        Map<String, Object> map = ActionUtil.getModelMap("Module");
        map.put("PageTitle", "loginLogList");
        map.put("DashboardLink", SecurityConstants.DASHBOARD_LINK);
        List<LoginLog> logList = securityService.findAllLoginLog();
        map.put("logList", logList);

        return new ModelAndView("/security/login_log_list", map);
    }
}