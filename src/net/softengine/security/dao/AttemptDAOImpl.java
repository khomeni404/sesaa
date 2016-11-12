package net.softengine.security.dao;


import net.softengine.security.model.Attempt;
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
public class AttemptDAOImpl implements AttemptDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(Attempt attempt) {
        try {
            hibernateTemplate.persist(attempt);
            hibernateTemplate.flush();
            return true;
        } catch (Exception ex){
            return false;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(Attempt attempt) {
        hibernateTemplate.merge(attempt);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean delete(Attempt attempt) {
        hibernateTemplate.delete(attempt);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public List<Attempt> findAllAttempt() {
        return (List<Attempt> ) hibernateTemplate.find("from Attempt");
    }

    @Override
    public List<Attempt> findAllAttempt(String searchText) {
        Object[] param = new Object[1];
        param[0] = "%"+searchText+"%";
        try {
            return (List<Attempt> ) hibernateTemplate.find("from Attempt where name like ?", param);
        }catch (IndexOutOfBoundsException ex){
            return null;
        }
    }

    @Override
    public Attempt getAttempt(Long id) {
        return hibernateTemplate.get(Attempt.class, id);
    }

    @Override
    public Attempt findByAttemptName(String attemptName){
        Object[] paramArr = new Object[1];
        paramArr[0] = new String(attemptName);
        try {
            return (Attempt) hibernateTemplate.find("from Attempt where name=?", paramArr).get(0);
        }catch (IndexOutOfBoundsException ex){
            return null;
        }
    }
}
