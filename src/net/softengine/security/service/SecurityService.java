package net.softengine.security.service;

import java.util.List;

import net.softengine.security.model.*;

public interface SecurityService {

    // Token
    public boolean update(Token token);

    //LoginLog
    public boolean save(LoginLog log);

    public boolean saveLoginLog(User user, Boolean in);

    public boolean update(LoginLog log);

    public boolean delete(LoginLog log);

    public List<LoginLog> findAllLoginLog();

    public List<LoginLog> findAllLoginLog(String searchText);

    public LoginLog getLoginLog(Long id);

    public LoginLog findByLoginLogName(String logName);


    //Attempt
    public boolean save(Attempt attempt);

    public boolean update(Attempt attempt);

    public boolean delete(Attempt attempt);

    public List<Attempt> findAllAttempt();

    public List<Attempt> findAllAttempt(String searchText);

    public Attempt getAttempt(Long id);

    public Attempt findByAttemptName(String attemptName);

    //Operation
    public boolean save(Operation operation);

    public List<Operation> findAllOperation();

    public Operation findOperationByName(String name);

    public boolean update(Operation operation);

    public Operation getOperation(Long id);

    public List<Operation> findAllOperations();

    public boolean delete(Operation operation);

    List<Operation> getOperationList(Authority authority);

    //Module
    public boolean save(Module module);

    public boolean update(Module module);

    public boolean delete(Module module);

    public List<Module> findAllModule();

    public List<Module> findAllModule(String searchText);

    public Module getModule(Long id);

    public Module getModule(String moduleName);

    //AuthorizedGroup
    public boolean save(Group groups);

    public boolean update(Group groups);

    public boolean delete(Group groups);

    public List<Group> findAllGroup();

    public Group getGroup(Long id);

    public Group getGroup(String groupName);


    //UserGroup
    public boolean save(UserGroup group);

    public boolean update(UserGroup group);

    public boolean delete(UserGroup group);

    public List<UserGroup> findAllUserGroup();

    public List<UserGroup> findAllUserGroup(String searchText);

    public UserGroup getUserGroup(Long id);

    public UserGroup getUserGroup(String groupName);


    //Authority
    public boolean save(Authority authority);

    public boolean update(Authority authority);

    public boolean delete(Authority authority);

    public List<Authority> findAllAuthority();

    public List<Authority> findAllAuthority(String searchText);

    public Authority getAuthority(Long id);

    public Authority findByAuthorityName(String authorityName);

    List<Authority> getAuthorityList(Group authorizedGroup);


    //public boolean save(Module component);

    public List<Module> findAllModules();

    public Module getModuleById(Long componentId);

    public Module getModuleByName(String componentName);

    //public boolean delete(Module component);

    public List<Authority> findAllAuthorities(List<Group> authorizedGroups);

    public List<Operation> findAllOperations(List<Authority> authorities);


    //Assigning Operation, Authorities, Groups
    public boolean updateAuthorityOperations(Long authId, String operations);

    public boolean updateGroupAuthorities(Long groupId, String authorities);

    public boolean updateUserGroups(Long userId, String groups);


}
