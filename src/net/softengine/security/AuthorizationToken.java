package net.softengine.security;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.softengine.security.dao.SecurityDAO;
import net.softengine.security.dao.UserDao;
import net.softengine.security.model.Authority;
import net.softengine.security.service.AuthorizationTokenService;
import net.softengine.security.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;

import net.softengine.security.model.Group;
import net.softengine.security.model.Operation;
import net.softengine.security.model.User;
import net.softengine.security.service.UserDetailsService;
import net.softengine.constant.SecurityConstants;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


/**
 * Copyright @ Soft Engine Inc.
 * Created on 22/05/16
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 22/11/15
 * Version : 1.0
 * This class contains the functionality to find out user's authorized groups,
 * operations and authorized features and store them into session attributes.
 *
 */


//@Service
public class AuthorizationToken implements AuthorizationTokenService{

    /*@Autowired
    public SecurityDAO securityDAO;*/

	public User principal;


	public List<Operation> grantedOperations;

	public AuthorizationToken(User user, List<Operation> operationList) {
        principal = user;
        grantedOperations = operationList;
        setAuthenticationToken();
    }

    /**
	 * This method contains the functionality to find out user's authorized groups,
	 * operations and authorized features and store them into session attributes.
	 */
    @Override
	public void setAuthenticationToken(){

		if(principal != null){
			
			HttpSession session = SessionUtil.getSession();

			session.setAttribute(SecurityConstants.SESSION_USER, principal);
			session.setAttribute(SecurityConstants.SESSION_USER_ID, principal.getId());
			session.setAttribute(SecurityConstants.SESSION_USER_USERNAME, principal.getToken().getUsername());
			session.setAttribute(SecurityConstants.SESSION_USER_DV, principal.getDiscriminatorValue());
			session.setAttribute(SecurityConstants.SESSION_USER_GRANTED_OPERATIONS, grantedOperations);
		}
		
		//TODO get the list of authorized groups, operations and aspects and put them in session.
	}
}
