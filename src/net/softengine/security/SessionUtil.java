package net.softengine.security;

import java.util.List;

import javax.servlet.http.HttpSession;

import net.softengine.security.model.Authority;
import net.softengine.security.model.Group;
import net.softengine.security.model.Operation;
import net.softengine.security.model.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import net.softengine.constant.SecurityConstants;

/**
 * Copyright @ Soft Engine Inc.
 * Created on 22/05/16
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 22/11/15
 * Version : 1.0
 */

public class SessionUtil {

    public static HttpSession getSession() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attr.getRequest().getSession(true); // true == allow create
    }

    /**
     * Retrieves the logged-in user object
     *
     * @return User
     * The logged-in user object
     */
    public static User getSessionUser() {
        Object user = getSession().getAttribute(SecurityConstants.SESSION_USER);
        if (user instanceof User) {
            return (User) user;
        }
        return null;
    }

    /**
     * Retrieves the logged-in user
     *
     * @return Long
     * The logged-in user id
     */
    public static Long getSessionUserId() {

        Object userId = getSession().getAttribute(SecurityConstants.SESSION_USER_ID);
        if (userId instanceof Long) {
            return (Long) userId;
        }
        return null;
    }

    public static String getSessionUsername() {

        Object userId = getSession().getAttribute(SecurityConstants.SESSION_USER_USERNAME);
        if (userId instanceof String) {
            return (String) userId;
        }
        return null;
    }

    public static String getSessionUserType() {
        Object discriminatorValue = getSession().getAttribute(SecurityConstants.SESSION_USER_DV);
        return discriminatorValue.toString();
    }

    /**
     * Retrieves the logged-in user groups
     *
     * @return List<AuthorizedGroups>
     * The list of authorized user groups for the session user.
     */
    @SuppressWarnings("unchecked")
    public static List<Group> getSessionUserAuthorizedGroups() {

        List<Group> authorizedGroups = (List<Group>) getSession().getAttribute(SecurityConstants.SESSION_USER_AUTHORIZED_GROUPS);
        if (authorizedGroups != null) {
            return authorizedGroups;
        }
        return null;
    }

    /**
     * Retrieves the logged-in user operations
     *
     * @return List<Authority>
     * The list of operations for the session user.
     */
    @SuppressWarnings("unchecked")
    public static List<Authority> getSessionUserAuthorities() {

        List<Authority> authorities = (List<Authority>) getSession().getAttribute(SecurityConstants.SESSION_USER_AUTHORITIES);
        if (authorities != null) {
            return authorities;
        }
        return null;
    }

    /**
     * Retrieves the logged-in user aspects
     *
     * @return List<Feature>
     * The list of operations for the session user.
     */
    @SuppressWarnings("unchecked")
    public static List<Operation> getSessionUserFeatures() {
        List<Operation> operations = (List<Operation>) getSession().getAttribute(SecurityConstants.SESSION_USER_GRANTED_OPERATIONS);
        if (operations != null) {
            return operations;
        }
        return null;
    }
}
