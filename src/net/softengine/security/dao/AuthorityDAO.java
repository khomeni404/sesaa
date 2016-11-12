package net.softengine.security.dao;


import net.softengine.security.model.Authority;
import net.softengine.security.model.Group;
import net.softengine.security.model.Operation;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: MAyatullah
 * Date: 8/23/14
 * Time: 4:16 PM
 * To change this template use File | Settings | File Templates.
 */
public interface AuthorityDAO {
    public boolean save(Authority authority);

    public boolean update(Authority authority);

    public boolean delete(Authority authority);

    public List<Authority> findAllAuthority();

    public List<Authority> findAllAuthority(String searchText);

    public Authority getAuthority(Long id);

    public Authority findByAuthorityName(String authorityName);



    public List<Authority> findAllAuthorities(List<Group> authorizedGroups);

    public List<Operation> findAllOperations(List<Authority> authorities);



}
