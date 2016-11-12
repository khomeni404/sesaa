package net.softengine.security.dao;

import java.util.List;

import net.softengine.security.model.Authority;
import net.softengine.security.model.Group;
import net.softengine.security.model.Operation;
import net.softengine.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AuthenticationAndAuthorizationDaoImpl implements
		AuthenticationAndAuthorizationDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public boolean authorizedGroupsAssignmentToUser(
			User user, List<Group> authorizedGroups) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean authorityAssignmentToAuthorizedGroups(
			Group group, List<Authority> authorities) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean featureAssignmentToAuthority(Authority authority,
			List<Operation> operations) {
		// TODO Auto-generated method stub
		return false;
	}

}
