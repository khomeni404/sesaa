package net.softengine;

import net.softengine.constant.SEConstants;
import net.softengine.security.SessionUtil;
import net.softengine.security.model.User;
import net.softengine.security.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright @ Soft Engine Inc.
 * Created on 22/05/16
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 22/11/15
 * Version : 1.0
 */

@Controller
@RequestMapping("/home2/")
public class HomeController {
    @Autowired
    public SecurityService securityService;

    @RequestMapping(method = RequestMethod.GET, value = "/home.se")
    public ModelAndView home() {
        Map<String, Object> map = new HashMap<>();
        map.put("DashBoardLink", SEConstants.DASHBOARD_LINK);
        map.put("PageTitle", "Home");
        User user = SessionUtil.getSessionUser();
        if (user != null) {
            securityService.saveLoginLog(user, true);
            return new ModelAndView("home/dashboard", map);
        } else {
            return new ModelAndView("redirect:/");
        }
    }


    @RequestMapping(method = RequestMethod.GET, value = "/genError.se")
    public ModelAndView genError(@RequestParam(required = false) String PageTitle,
                                 @RequestParam(required = false) String errorMsg) {
        Map<String, Object> map = new HashMap<>();
        map.put("DashBoardLink", SEConstants.DASHBOARD_LINK);
        map.put("PageTitle", PageTitle);
        map.put("errorMsg", errorMsg);
        return new ModelAndView("home/gen_error_page", map);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/genSuccess.se")
    public ModelAndView genSuccess(@RequestParam(required = false) String PageTitle,
                                   @RequestParam(required = false) String successMsg) {
        Map<String, Object> map = new HashMap<>();
        map.put("DashBoardLink", SEConstants.DASHBOARD_LINK);
        map.put("PageTitle", PageTitle);
        map.put("successMsg", successMsg);
        return new ModelAndView("home/gen_success_page", map);
    }
}
