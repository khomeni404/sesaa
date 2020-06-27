package net.softengine.security.dao;

import net.softengine.security.model.*;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Khomeni on 03-Mar-17.
 */

@Repository
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class SecurityDaoImpl implements SecurityDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    @SuppressWarnings("unchecked")
    public <MODEL> List<MODEL> findAll(Class<MODEL> clazz, String propertyName, Object propertyValue) {
        DetachedCriteria criteria = DetachedCriteria.forClass(clazz)
                .add(Restrictions.eq(propertyName, propertyValue));
        return (List<MODEL>) hibernateTemplate.findByCriteria(criteria);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <MODEL> List<MODEL> findAll(Class<MODEL> clazz, String aliasModel, String propertyName, Object propertyValue) {
        DetachedCriteria criteria = DetachedCriteria.forClass(clazz)
                .createAlias(aliasModel, "model2")
                .add(Restrictions.eq("model2." + propertyName, propertyValue));
        return (List<MODEL>) hibernateTemplate.findByCriteria(criteria);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Authority> getAuthorityList(Group authorizedGroup) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Authority.class)
                .createAlias("groupList", "group")
                .add(Restrictions.eq("group.id", authorizedGroup.getId()));
        return (List<Authority>) hibernateTemplate.findByCriteria(criteria);
    }
    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUserList(Group authorizedGroup) {
        DetachedCriteria criteria = DetachedCriteria.forClass(User.class)
                .createAlias("groupList", "group")
                .add(Restrictions.eq("group.id", authorizedGroup.getId()));
        return (List<User>) hibernateTemplate.findByCriteria(criteria);
    }

    @Override
    public List<Group> getGroupList(User user) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Group.class)
                .createAlias("userList", "User")
                .add(Restrictions.eq("User.id", user.getId()));
        return (List<Group>) hibernateTemplate.findByCriteria(criteria);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Operation> getOperationList(Authority authority) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Operation.class)
                .createAlias("authorityList", "authority")
                .add(Restrictions.eq("authority.id", authority.getId()));
        return (List<Operation>) hibernateTemplate.findByCriteria(criteria);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Group> getGroupList(Authority authority) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Group.class)
                .createAlias("authorityList", "authority")
                .add(Restrictions.eq("authority.id", authority.getId()));
        return (List<Group>) hibernateTemplate.findByCriteria(criteria);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Operation> getOperationList(Module module) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Operation.class)
                .add(Restrictions.eq("module", module));
        return (List<Operation>) hibernateTemplate.findByCriteria(criteria);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUserList(Module module) {
        return new ArrayList<>();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Authority> getAuthorityList(Operation operation) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Authority.class)
                .createAlias("operationList", "operation")
                .add(Restrictions.eq("operation.id", operation.getId()));
        return (List<Authority>) hibernateTemplate.findByCriteria(criteria);
    }
}
