package net.softengine.security.dao;

import net.softengine.security.model.*;

import java.util.List;

/**
 * Created by Khomeni on 03-Mar-17.
 */


public interface SecurityDAO {
    <MODEL> List<MODEL> findAll(Class<MODEL> clazz, String propertyName, Object propertyValue);

    <MODEL> List<MODEL> findAll(Class<MODEL> clazz, String aliasModel, String propertyName, Object propertyValue);

    List<Authority> getAuthorityList(Group authorizedGroup);

    List<User> getUserList(Group authorizedGroup);

    List<Operation> getOperationList(Authority authority);

    List<Group> getGroupList(Authority authority);

    List<Operation> getOperationList(Module module);

    List<User> getUserList(Module module);

    List<Authority> getAuthorityList(Operation operation);
}
