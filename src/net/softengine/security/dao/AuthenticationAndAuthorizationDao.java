package net.softengine.security.dao;

import java.util.List;

import net.softengine.security.model.Operation;
import net.softengine.security.model.Authority;
import net.softengine.security.model.Group;
import net.softengine.security.model.User;

public interface AuthenticationAndAuthorizationDao {

	public boolean authorizedGroupsAssignmentToUser(User user, List<Group> authorizedGroups);
	
	public boolean authorityAssignmentToAuthorizedGroups(Group group, List<Authority> authorities);
	
	public boolean featureAssignmentToAuthority(Authority authority, List<Operation> operations);

}
