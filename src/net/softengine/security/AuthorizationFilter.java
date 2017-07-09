package net.softengine.security;

import net.softengine.security.model.Operation;
import net.softengine.security.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright @ Soft Engine Inc.
 * Created on 22/05/2016
 * Created By : Khomeni
 * Version : 1.0
 * This class acts as a bridge between AuthenticationController and AuthorizationToken
 */

public class AuthorizationFilter {

    public static AuthorizationToken setAuthorization(User user, List<Operation> operationList) {
        return new AuthorizationToken(user, operationList);
    }

}
