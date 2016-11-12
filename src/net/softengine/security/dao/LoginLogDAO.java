package net.softengine.security.dao;


import net.softengine.security.model.LoginLog;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: MAyatullah
 * Date: 8/23/14
 * Time: 4:16 PM
 * To change this template use File | Settings | File Templates.
 */
public interface LoginLogDAO {
    public boolean save(LoginLog log);

    public boolean update(LoginLog log);

    public boolean delete(LoginLog log);

    public List<LoginLog> findAllLoginLog();

    public List<LoginLog> findAllLoginLog(String searchText);

    public LoginLog getLoginLog(Long id);

    public LoginLog findByLoginLogName(String logName);

}
