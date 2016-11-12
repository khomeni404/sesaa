package net.softengine.security.dao;


import net.softengine.security.model.Authority;
import net.softengine.security.model.Group;
import net.softengine.security.model.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: MAyatullah
 * Date: 8/23/14
 * Time: 4:18 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class AuthorityDaoImpl implements AuthorityDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(Authority authority) {
        try {
            hibernateTemplate.persist(authority);
            hibernateTemplate.flush();
            return true;
        } catch (Exception ex){
            return false;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(Authority authority) {
        hibernateTemplate.merge(authority);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean delete(Authority authority) {
        hibernateTemplate.delete(authority);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public List<Authority> findAllAuthority() {
        return (List<Authority> ) hibernateTemplate.find("from Authority");
    }

    @Override
    public List<Authority> findAllAuthority(String searchText) {
        Object[] param = new Object[1];
        param[0] = "%"+searchText+"%";
        try {
            return (List<Authority> ) hibernateTemplate.find("from Authority where name like ?", param);
        }catch (IndexOutOfBoundsException ex){
            return null;
        }
    }

    @Override
    public Authority getAuthority(Long id) {
        return hibernateTemplate.get(Authority.class, id);
    }

    @Override
    public Authority findByAuthorityName(String authorityName){
        Object[] paramArr = new Object[]{authorityName};
        try {
            return (Authority) hibernateTemplate.find("from Authority where name=?", paramArr).get(0);
        }catch (IndexOutOfBoundsException ex){
            return null;
        }
    }


    @Override
    public List<Authority> findAllAuthorities(List<Group> authorizedGroups) {
        return (List<Authority>) hibernateTemplate.find(" from Authority ");
    }

    @Override
    public List<Operation> findAllOperations(List<Authority> authorities) {
        return (List<Operation>) hibernateTemplate.find(" from Operation ");
    };
}
