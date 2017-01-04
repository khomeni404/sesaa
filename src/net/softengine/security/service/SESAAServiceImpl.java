package net.softengine.security.service;

import net.softengine.security.AuthorizationFilter;
import net.softengine.security.SessionUtil;
import net.softengine.security.dao.GroupDAO;
import net.softengine.security.dao.UserDao;
import net.softengine.security.model.Authority;
import net.softengine.security.model.Group;
import net.softengine.security.model.Operation;
import net.softengine.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SESAAServiceImpl implements
        SESAAService {

    @Autowired
    private UserDao userDao;
    @Autowired
    GroupDAO groupDao;

    @Override
    public boolean authenticate(String username, String password) {
        // call dao method to retrieve the user object
        User user = userDao.get(username, password);

        if (user instanceof User) {
            // call authenticationfilter
            user.setLastActivity(new Date());
            AuthorizationFilter.setAuthorization(user);

            return true;
        }
        return false;
    }


    @Override
    public boolean checkAuthorization(String operationName) {
        boolean isAllowed = false;
        for (Operation operation : SessionUtil.getSessionUserFeatures()) {
            if (operation.getName().equals(operationName)) {
                isAllowed = true;
                break;
            }
        }
        return isAllowed;
    }

    @Override
    public boolean checkAuthorization(List<Operation> operations, String operationName) {
        boolean isAllowed = false;
        for (Operation operation : operations) {
            if (operation.getName().equals(operationName)) {
                isAllowed = true;
                break;
            }
        }
        return isAllowed;
    }

    @Override
    public boolean checkAuthorization(List<Operation> operations, String controller, String operationName) {
        boolean isAllowed = false;
        for (Operation operation : operations) {
            String thisOperation = operation.getModule().getName();
            String thisOperationName = operation.getName();
            if (thisOperation.equals(controller) && thisOperationName.equals(operationName)) {
                isAllowed = true;
                break;
            }
        }
        return isAllowed;
    }

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
    public boolean aspectAssignmentToAuthority(Authority authority,
                                               List<Operation> operations) {
        // TODO Auto-generated method stub
        return false;
    }


    // AuthorizedGroups

    @Override
    public Group getAuthorizedGroups(Long id) {
        return groupDao.getGroup(id);
    }

    @Override
    public List<Group> findAllAuthorizedGroups() {
        return groupDao.findAllGroup();
    }
}
