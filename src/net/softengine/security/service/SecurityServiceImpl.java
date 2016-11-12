package net.softengine.security.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.softengine.security.dao.*;
import net.softengine.security.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    private OperationDAO operationDAO;
    @Autowired
    private AuthorityDAO authorityDAO;
    @Autowired
    private UserGroupDAO userGroupDAO;
    @Autowired
    private GroupDAO groupDAO;
    @Autowired
    private ModuleDAO moduleDAO;
    @Autowired
    private AttemptDAO attemptDAO;
    @Autowired
    private UserDao userDao;
    @Autowired
    private LoginLogDAO loginLogDAO;

    @Autowired
    private TokenDao tokenDao;

    // Token

    @Override
    public boolean update(Token token) {
        return tokenDao.update(token);
    }


    //Attempt
    @Override
    public boolean save(Attempt attempt) {
        return attemptDAO.save(attempt);
    }

    @Override
    public boolean update(Attempt attempt) {
        return attemptDAO.update(attempt);
    }

    @Override
    public boolean delete(Attempt attempt) {
        return attemptDAO.delete(attempt);
    }

    @Override
    public List<Attempt> findAllAttempt() {
        return attemptDAO.findAllAttempt();
    }

    @Override
    public List<Attempt> findAllAttempt(String searchText) {
        return attemptDAO.findAllAttempt(searchText);
    }

    @Override
    public Attempt getAttempt(Long id) {
        return attemptDAO.getAttempt(id);
    }

    @Override
    public Attempt findByAttemptName(String attemptName) {
        return attemptDAO.findByAttemptName(attemptName);
    }


    //LoginLog
    @Override
    public boolean saveLoginLog(User user, Boolean in) {
        LoginLog log = new LoginLog();
        log.setIn(in);
        log.setDate(new Date());
        log.setTime(new Date());
        log.setUser(user);
        return loginLogDAO.save(log);
    }

    @Override
    public boolean save(LoginLog loginLog) {
        return loginLogDAO.save(loginLog);
    }



    @Override
    public boolean update(LoginLog loginLog) {
        return loginLogDAO.update(loginLog);
    }

    @Override
    public boolean delete(LoginLog loginLog) {
        return loginLogDAO.delete(loginLog);
    }

    @Override
    public List<LoginLog> findAllLoginLog() {
        return loginLogDAO.findAllLoginLog();
    }

    @Override
    public List<LoginLog> findAllLoginLog(String searchText) {
        return loginLogDAO.findAllLoginLog(searchText);
    }

    @Override
    public LoginLog getLoginLog(Long id) {
        return loginLogDAO.getLoginLog(id);
    }

    @Override
    public LoginLog findByLoginLogName(String loginLogName) {
        return loginLogDAO.findByLoginLogName(loginLogName);
    }

    @Override
    public List<Authority> findAllAuthorities(List<Group> authorizedGroups) {
        return authorityDAO.findAllAuthorities(authorizedGroups);
    }

    @Override
    public List<Operation> findAllOperations(List<Authority> authorities) {
        return authorityDAO.findAllOperations(authorities);
    }

    @Override
    public Module getModuleById(Long moduleId) {
        return moduleDAO.getModuleById(moduleId);
    }

    @Override
    public Module getModuleByName(String moduleName) {
        return moduleDAO.getModuleByName(moduleName);
    }

    //Group
    @Override
    public boolean save(Group group) {
        return groupDAO.save(group);
    }

    @Override
    public boolean update(Group groups) {
        return groupDAO.update(groups);
    }

    @Override
    public boolean delete(Group groups) {
        groups.getAuthorityList().removeAll(groups.getAuthorityList());
        return groupDAO.delete(groups);
    }

    @Override
    public List<Group> findAllGroup() {
        return groupDAO.findAllGroup();
    }

    @Override
    public Group getGroup(Long id) {
        return groupDAO.getGroup(id);
    }

    @Override
    public Group getGroup(String groupName) {
        return groupDAO.getGroup(groupName);
    }

    //Module
    @Override
    public boolean save(Module module) {
        return moduleDAO.save(module);
    }

    @Override
    public boolean update(Module module) {
        return moduleDAO.update(module);
    }

    @Override
    public boolean delete(Module module) {
        return moduleDAO.delete(module);
    }

    @Override
    public List<Module> findAllModule() {
        return moduleDAO.findAllModule();
    }

    @Override
    public List<Module> findAllModule(String searchText) {
        return moduleDAO.findAllModule(searchText);
    }

    @Override
    public Module getModule(Long id) {
        return moduleDAO.getModule(id);
    }

    @Override
    public Module getModule(String moduleName) {
        return moduleDAO.getModule(moduleName);
    }

    //Feature
    @Override
    public boolean save(Operation operation) {
        return operationDAO.save(operation);
    }

    @Override
    public Operation findOperationByName(String operation) {
        return operationDAO.findOperationByName(operation);
    }

    @Override
    public boolean update(Operation operation) {
        return operationDAO.update(operation);
    }

    @Override
    public Operation getOperation(Long id) {
        return operationDAO.getOperation(id);
    }

    @Override
    public List<Operation> findAllOperations() {
        return null;
    }

    @Override
    public List<Operation> findAllOperation() {
        return operationDAO.findAllOperations();
    }

    @Override
    public boolean delete(Operation operation) {
        return operationDAO.delete(operation);
    }

    //Group


    //UserGroup
    @Override
    public boolean save(UserGroup group) {
        return userGroupDAO.save(group);
    }

    @Override
    public boolean update(UserGroup group) {
        return userGroupDAO.update(group);
    }

    @Override
    public boolean delete(UserGroup group) {
        return userGroupDAO.delete(group);
    }

    @Override
    public List<UserGroup> findAllUserGroup() {
        return userGroupDAO.findAllUserGroup();
    }

    @Override
    public List<UserGroup> findAllUserGroup(String searchText) {
        return userGroupDAO.findAllUserGroup(searchText);
    }

    @Override
    public UserGroup getUserGroup(Long id) {
        return userGroupDAO.getUserGroup(id);
    }

    @Override
    public UserGroup getUserGroup(String groupName) {
        return userGroupDAO.getUserGroup(groupName);
    }

    //Authority
    @Override
    public boolean save(Authority authority) {
        return authorityDAO.save(authority);
    }

    @Override
    public boolean update(Authority authority) {
        return authorityDAO.update(authority);
    }

    @Override
    public boolean delete(Authority authority) {
        return authorityDAO.delete(authority);
    }

    @Override
    public List<Authority> findAllAuthority() {
        return authorityDAO.findAllAuthority();
    }

    @Override
    public List<Authority> findAllAuthority(String searchText) {
        return authorityDAO.findAllAuthority();
    }

    @Override
    public Authority getAuthority(Long id) {
        return authorityDAO.getAuthority(id);
    }

    @Override
    public Authority findByAuthorityName(String authorityName) {
        return authorityDAO.findByAuthorityName(authorityName);
    }

    @Override
    public boolean updateAuthorityOperations(Long authId, String operations) {
        Authority authority = authorityDAO.getAuthority(authId);
        List<Operation> operationList = new ArrayList<>();
        String[] opIsArr = operations.split(",");
        for (String s : opIsArr) {
            Long opId = Long.valueOf(s.trim());
            Operation op = operationDAO.getOperation(opId);
            operationList.add(op);
        }
        authority.setOperationList(operationList);
        return authorityDAO.update(authority);
    }

    @Override
    public boolean updateGroupAuthorities(Long groupId, String authorities) {
        Group group = groupDAO.getGroup(groupId);
        List<Authority> authorityList = new ArrayList<>();
        String[] idArray = authorities.split(",");
        for (String s : idArray) {
            Long id = Long.valueOf(s.trim());
            Authority authority = authorityDAO.getAuthority(id);
            authorityList.add(authority);
        }
        group.setAuthorityList(authorityList);
        return groupDAO.update(group);
    }
    @Override
    public boolean updateUserGroups(Long userId, String groups) {
        User user =userDao.get(userId);
        List<Group> groupList = new ArrayList<>();
        if (groups != null) {
            String[] idArray = groups.split(",");
            for (String s : idArray) {
                Long id = Long.valueOf(s.trim());
                Group group = groupDAO.getGroup(id);
                groupList.add(group);
            }
            user.setGroupList(groupList);
        } else {
            user.setGroupList(null);
        }
        return userDao.update(user);
    }

    @Override
    public List<Module> findAllModules() {
        return moduleDAO.findAllModules();
    }



}
