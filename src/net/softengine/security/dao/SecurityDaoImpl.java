package net.softengine.security.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
}
