package net.softengine.security;

import net.softengine.constant.SecurityConstants;
import net.softengine.security.model.User;
import net.softengine.security.service.SESAAService;
import net.softengine.security.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Copyright @ Soft Engine Inc.
 * Created on 22/05/2016
 * Created By : Khomeni
 * Version : 1.0
 */

@Controller
@RequestMapping(name = "security", value = {"/auth/", "/login/"}, method = {RequestMethod.GET, RequestMethod.HEAD})
public class AuthenticationController {

    @Autowired
    private SESAAService authService;

    @Autowired
    public SecurityService securityService;

    @RequestMapping(method = RequestMethod.HEAD, value = {"/login.se", "/"})
    public ModelAndView login() throws Exception {
        //bootStrap.createDefaultAdmin();
        return new ModelAndView("home/login");
    } // abcdef g hi - babu jamal shiltu

    @RequestMapping(method = RequestMethod.POST, value = "/authenticateUser.se")
    public ModelAndView authenticateUser(@RequestParam("username") String username,
                                         @RequestParam("password") String password) throws Exception {
//        Map<String, Object> map = ActionUtil.getModelMap("Module");
        // Call the service method to retrieve the user object by username and password.
        boolean isAuthenticated = authService.authenticate(username, password);
        if (isAuthenticated) {
//            if (username.equals("mak")) {
//                return new ModelAndView("redirect:/supp/home.se");
//            } else {
                return new ModelAndView("redirect:/home/home.se");
            //}
        } else {
            return new ModelAndView("redirect:/");
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/logout.se")
    public ModelAndView logout() {
        User user = SessionUtil.getSessionUser();
        securityService.saveLoginLog(user, false);
        HttpSession userSession = SessionUtil.getSession();
        userSession.removeAttribute(SecurityConstants.SESSION_USER);
        userSession.removeAttribute(SecurityConstants.SESSION_USER_GRANTED_OPERATIONS);
        userSession.removeAttribute(SecurityConstants.SESSION_USER_ID);
        userSession.removeAttribute(SecurityConstants.SESSION_USER_AUTHORIZED_GROUPS);
        userSession.removeAttribute(SecurityConstants.SESSION_USER_AUTHORITIES);
        userSession.invalidate();
        return new ModelAndView("redirect:/auth/login.se");
    }

}
