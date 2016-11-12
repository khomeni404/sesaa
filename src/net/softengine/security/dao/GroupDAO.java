package net.softengine.security.dao;

import net.softengine.security.model.Group;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: MAyatullah
 * Date: 8/23/14
 * Time: 4:16 PM
 * To change this template use File | Settings | File Templates.
 */
public interface GroupDAO {
    public boolean save(Group groups);

    public boolean update(Group groups);

    public boolean delete(Group groups);

    public List<Group> findAllGroup();

    public Group getGroup(Long id);

    public Group getGroup(String groupName);

}
