package net.softengine.security.dao;


import net.softengine.security.model.Module;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: MAyatullah
 * Date: 8/23/14
 * Time: 4:16 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ModuleDAO {
    public boolean save(Module module);

    public boolean update(Module module);

    public boolean delete(Module module);

    public List<Module> findAllModule();

    public List<Module> findAllModule(String searchText);

    public Module getModule(Long id);

    public Module getModule(String moduleName);

    public List<Module> findAllModules();

    public Module getModuleById(Long componentId);

    public Module getModuleByName(String componentName);

}
