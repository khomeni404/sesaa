package net.softengine.security.dao;

import java.util.List;

import net.softengine.security.model.Operation;

public interface OperationDAO {
	
	public boolean save(Operation operation);

    public boolean update(Operation operation);

    public Operation findOperationByName(String operation);

    public Operation getOperation(Long id);
	
	public List<Operation> findAllOperations();
	
	public boolean delete(Operation operation);
	
/*	public boolean save(Authority authority);

    public boolean update(Authority authority);

    public Authority getAuthority(Long authorityId);
	
	public List<Authority> findAllAuthorities();
	
	public Authority findByAuthorityName(String authorityName);*/
	
	//public boolean delete(Authority authority);
	
	/*public boolean save(Module module);

    public boolean update(Module module);

    public Module getModule(int componentId);
	
	public List<Module> findAllModules();

    public Module getModuleById(Long componentId);

    public Module getModuleByName(String componentName);
	
	public boolean delete(Module module);

*/

	
}
