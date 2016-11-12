package net.softengine.security;

import net.softengine.security.model.User;

/**
 * This class acts as a bridge between AuthenticationController and AuthorizationToken
 */
public class AuthorizationFilter {

    public static AuthorizationToken setAuthorization(User user) {
        return new AuthorizationToken(user);
    }

}
