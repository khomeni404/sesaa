package net.softengine.security.dao;


import net.softengine.security.model.Attempt;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: MAyatullah
 * Date: 8/23/14
 * Time: 4:16 PM
 * To change this template use File | Settings | File Templates.
 */
public interface AttemptDAO {
    public boolean save(Attempt attempt);

    public boolean update(Attempt attempt);

    public boolean delete(Attempt attempt);

    public List<Attempt> findAllAttempt();

    public List<Attempt> findAllAttempt(String searchText);

    public Attempt getAttempt(Long id);

    public Attempt findByAttemptName(String attemptName);

}
