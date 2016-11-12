/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.softengine.security.service;



import net.softengine.security.dao.TokenDao;
import net.softengine.security.dao.UserDao;
import net.softengine.security.model.Token;
import net.softengine.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author khomeni
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private TokenDao tokenDao;


    @Override
    public User getUser(Long userID) {
        return userDao.get(userID);
    }

    @Override
    public User getUser(String username) {
        return userDao.get(username);
    }


    @Override
    public User getUserByEmail(String emailAddress) {
        return userDao.getUserByEmail(emailAddress);
    }

    @Override
    public boolean saveUser(Token token, String userType) {
        userDao.save(token);
        User user = new User();
        user.setToken(token);
        user.setActive(true);
        userDao.save(user);

        return true;
    }

    @Override
    public boolean deleteUser(Token token) {
        userDao.delete(token);
        User user = new User();
        Token token1 = user.getToken();
        User user1 = token1.getUser();
        userDao.delete(user1);
        return true;
    }

    @Override
    public boolean delete(User user) {
        user.getGroupList().remove(user);
        userDao.delete(user);
        Token token = user.getToken();
        userDao.delete(token);
        return true;
    }

    @Override
    public boolean saveUser(User user) {
        return userDao.save(user);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.update(user);
    }

    @Override
    public boolean updateToken(Token token) {
        return userDao.update(token);
    }

    @Override
    public boolean updateToken(User user) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public User findByUserCodeAndPassword(String username, String password) {
        return userDao.get(username, password);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public List<User> getAllTeacher() {
        return null;
    }

    @Override
    public User findUserByUserCode(String userCode) {
        return userDao.get(userCode);
    }

 /*   @Override
    public AuthorizedGroups findByAuthorizedGroupsName(
            String authorizedGroupsName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean saveAuthorizedGroups(AuthorizedGroups authorizedGroups) {
        // TODO Auto-generated method stub
        return false;
    }*/

    @Override
    public int count() {
        return userDao.count();
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userDao.get(username, password);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.get(username);
    }

    //Token Section

    @Override
    public boolean save(Token token) {
        return tokenDao.save(token);
    }

    @Override
    public boolean update(Token token) {
        return tokenDao.update(token);
    }

    @Override
    public boolean delete(Token token) {

        return tokenDao.delete(token);
    }

    @Override
    public List<Token> findAllToken() {
        return tokenDao.findAllToken();
    }

    @Override
    public Token getToken(Long id) {
        return tokenDao.getToken(id);
    }
    @Override
    public Token getToken(String username) {
        return tokenDao.getToken(username);
    }
}
