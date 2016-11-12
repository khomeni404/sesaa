package net.softengine.security.dao;

import net.softengine.security.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: M Ayatullah
 * Date: 8/23/14
 * Time: 4:18 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class GroupDaoImpl implements GroupDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(Group groups) {
        try {
            hibernateTemplate.persist(groups);
            hibernateTemplate.flush();
            return true;
        } catch (Exception ex){
            return false;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(Group groups) {
        hibernateTemplate.merge(groups);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean delete(Group groups) {
        hibernateTemplate.delete(groups);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public List<Group> findAllGroup() {
        return (List<Group> ) hibernateTemplate.find("from Group");
    }

    @Override
    public Group getGroup(Long id) {
        return hibernateTemplate.get(Group.class, id);
    }

    @Override
    public Group getGroup(String groupName){
        Object[] paramArr = new Object[1];
        paramArr[0] = new String(groupName);
        try {
            return (Group) hibernateTemplate.find("from Group where name=?", paramArr).get(0);
        }catch (IndexOutOfBoundsException ex){
            return null;
        }
    }
}
