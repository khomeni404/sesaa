package net.softengine.security.service;

import net.softengine.security.model.Authority;
import net.softengine.security.model.Group;
import net.softengine.security.model.Operation;
import net.softengine.security.model.User;

import java.util.List;

/**
 * Copyright &copy; Soft Engine Inc.
 * Created on 14/05/16
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 14/05/16
 * Version : 1.0
 */

public class AuthAuthServiceImpl implements AuthAuthService {
    @Override
    public boolean authenticate(String username, String password) {
        return false;
    }

    @Override
    public boolean checkAuthorization(List<Operation> operations, String controller, String operation) {
        return false;
    }

    @Override
    public boolean authorizedGroupsAssignmentToUser(User user, List<Group> authorizedGroups) {
        return false;
    }

    @Override
    public boolean authorityAssignmentToAuthorizedGroups(Group group, List<Authority> authorities) {
        return false;
    }

    @Override
    public boolean aspectAssignmentToAuthority(Authority authority, List<Operation> operations) {
        return false;
    }

    @Override
    public Group getAuthorizedGroups(Long id) {
        return null;
    }

    @Override
    public List<Group> findAllAuthorizedGroups() {
        return null;
    }
}
