package net.softengine.security.dao;


import net.softengine.security.model.Module;
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
public class ModuleDaoImpl implements ModuleDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(Module module) {
        try {
            hibernateTemplate.persist(module);
            hibernateTemplate.flush();
            return true;
        } catch (Exception ex){
            return false;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(Module module) {
        hibernateTemplate.merge(module);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean delete(Module module) {
        hibernateTemplate.delete(module);
        hibernateTemplate.flush();
        return true;
    }

    @Override
    public List<Module> findAllModule() {
        return  (List<Module>) hibernateTemplate.find("from Module");
    }

    @Override
    public List<Module> findAllModule(String searchText) {
        Object[] param = new Object[1];
        param[0] = "%"+searchText+"%";
        try {
            return (List<Module>) hibernateTemplate.find("from Module where name like ?", param);
        }catch (IndexOutOfBoundsException ex){
            return null;
        }
    }

    @Override
    public Module getModule(Long id) {
        return hibernateTemplate.get(Module.class, id);
    }

    @Override
    public Module getModule(String moduleName){
        Object[] paramArr = new Object[1];
        paramArr[0] = new String(moduleName);
        try {
            return (Module) hibernateTemplate.find("from Module where name=?", paramArr).get(0);
        }catch (IndexOutOfBoundsException ex){
            return null;
        }
    }

    @Override
    public List<Module> findAllModules() {
        return (List<Module>) hibernateTemplate.find(" from Module ");
    }

    @Override
    public Module getModuleById(Long moduleId) {

        return hibernateTemplate.get(Module.class, moduleId);

    }

    @Override
    @SuppressWarnings("unchecked")
    public Module getModuleByName(String moduleName) {
        Object[] param = new Object[]{moduleName};
        try {
            return (Module) hibernateTemplate.find(" from Module as module where module.name=?", param).get(0);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }

    }
}
