package net.softengine.security.dao;

import java.util.List;

/**
 * Created by Khomeni on 03-Mar-17.
 */
public interface SecurityDAO {
    <MODEL> List<MODEL> findAll(Class<MODEL> clazz, String propertyName, Object propertyValue);

    <MODEL> List<MODEL> findAll(Class<MODEL> clazz, String aliasModel, String propertyName, Object propertyValue);

}
