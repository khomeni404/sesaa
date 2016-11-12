package net.softengine.security.service;

import java.util.List;

import net.softengine.security.model.Authority;
import net.softengine.security.model.Group;
import net.softengine.security.model.Operation;
import net.softengine.security.model.User;

public interface AuthenticationAndAuthorizationService {
	
	public boolean authenticate(String username, String password);

    public boolean checkAuthorization(String operation);

    public boolean checkAuthorization(List<Operation> operations, String operation);

	public boolean checkAuthorization(List<Operation> operations, String controller, String operation);

	public boolean authorizedGroupsAssignmentToUser(User user, List<Group> authorizedGroups);
	
	public boolean authorityAssignmentToAuthorizedGroups(Group group, List<Authority> authorities);
	
	public boolean aspectAssignmentToAuthority(Authority authority, List<Operation> operations);

    //Authorized Groups
    public Group getAuthorizedGroups(Long id);
    public List<Group> findAllAuthorizedGroups();

}
