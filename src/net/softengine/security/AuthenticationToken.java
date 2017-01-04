package net.softengine.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.authentication.AbstractAuthenticationToken;
/**
 * Copyright @ Soft Engine Inc.
 * Created on 22/05/2016
 * Created By : Khomeni
 * Version : 1.0
 */
public class AuthenticationToken extends AbstractAuthenticationToken{
	
	String username;
    String password;
    String site;
    String domain;
    int userID;
    
	public AuthenticationToken(String username, String password,
                                  String site, String domain) {
		super(null);
		this.username = username;
		this.password = password;
		this.site = site;
		this.domain = domain;
	}

	public AuthenticationToken(Collection<GrantedAuthority> authorities, String username, String password,
                                  String site, String domain, int userID) {
		super(authorities);
		this.username = username;
		this.password = password;
		this.site = site;
		this.domain = domain;
		this.userID = userID;
		setAuthenticated(true);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return userID;
	}
    
}
