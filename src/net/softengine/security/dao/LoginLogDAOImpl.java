package net.softengine.security.dao;


import net.softengine.security.model.LoginLog;
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
public class LoginLogDAOImpl implements LoginLogDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(LoginLog log) {
        try {
            hibernateTemplate.persist(log);
            return true;
        } catch (Exception ex){
            return false;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(LoginLog log) {
        hibernateTemplate.merge(log);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean delete(LoginLog log) {
        hibernateTemplate.delete(log);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public List<LoginLog> findAllLoginLog() {
        return (List<LoginLog> ) hibernateTemplate.find("from LoginLog");
    }

    @Override
    public List<LoginLog> findAllLoginLog(String searchText) {
        Object[] param = new Object[1];
        param[0] = "%"+searchText+"%";
        try {
            return (List<LoginLog> ) hibernateTemplate.find("from LoginLog where name like ?", param);
        }catch (IndexOutOfBoundsException ex){
            return null;
        }
    }

    @Override
    public LoginLog getLoginLog(Long id) {
        return hibernateTemplate.get(LoginLog.class, id);
    }

    @Override
    public LoginLog findByLoginLogName(String logName){
        Object[] paramArr = new Object[1];
        paramArr[0] = new String(logName);
        try {
            return (LoginLog) hibernateTemplate.find("from LoginLog where name=?", paramArr).get(0);
        }catch (IndexOutOfBoundsException ex){
            return null;
        }
    }
}
