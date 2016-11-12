package net.softengine.security.service;

import net.softengine.security.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright &copy; Soft Engine Inc.
 * Created on 13/05/16
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 13/05/16
 * Version : 1.0
 */

@Service
public class ConfigureServiceImpl implements ConfigureService{
    @Autowired
    private SecurityService securityService;
    @Autowired
    private UserDetailsService userDetailsService;

    List<Operation> operations;
    List<Authority> authorities;
    List<Group> authorizedCumulativeGroups;

    public List<Group> initializeDefaultSecurityData() {
        try {
            Module securityModule = new Module();
            securityModule.setName("security");
            securityModule.setDescription("Security Related Module");
            securityService.save(securityModule);

            Module adminModule = new Module();
            adminModule.setName("account");
            adminModule.setDescription("Admin Related Module");
            securityService.save(adminModule);

            operations = new ArrayList<Operation>();

            Operation saveOperation = new Operation();
            saveOperation.setModule(securityModule);
            saveOperation.setName("saveUser");
            saveOperation.setDescription("Saving User Feature");
            securityService.save(saveOperation);
            operations.add(saveOperation);

            Operation createOperation = new Operation();
            createOperation.setModule(securityModule);
            createOperation.setName("createUser");
            createOperation.setDescription("Creating User Feature");
            securityService.save(createOperation);
            operations.add(createOperation);

            Operation operationList = new Operation();
            operationList.setModule(securityModule);
            operationList.setName("featureList");
            operationList.setDescription("Creating User Feature");
            securityService.save(operationList);
            operations.add(operationList);

            Operation userListOperation = new Operation();
            userListOperation.setModule(securityModule);
            userListOperation.setName("userList");
            userListOperation.setDescription("Listing all User Feature");
            securityService.save(userListOperation);
            operations.add(userListOperation);

            Operation userJsonDataOperation = new Operation();
            userJsonDataOperation.setModule(securityModule);
            userJsonDataOperation.setName("userJsonData");
            userJsonDataOperation.setDescription("User List Json Data");
            securityService.save(userJsonDataOperation);
            operations.add(userJsonDataOperation);


            Authority authority = new Authority();
            authority.setName("super_admin");
            authority.setDescription("Super Admin Authority");
            authority.setOperationList(operations);
            securityService.save(authority);
            authorities = new ArrayList<Authority>();
            authorities.add(authority);

            Group group = new Group();
            group.setName("System Engineer Group");
            group.setDescription("Engineering the whole system having this privilege");
            group.setAuthorityList(authorities);
            securityService.save(group);

            authorizedCumulativeGroups = new ArrayList<Group>();
            authorizedCumulativeGroups.add(group);
            return authorizedCumulativeGroups;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void testSave() {
        System.out.println("securityService = " + securityService.hashCode());

        System.out.println("storeDAO");
    }

    @Override
    public void createDefaultAdmin() {
        if (userDetailsService.count() == 0) {
            Token token = new Token();
            token.setUsername("account");
            token.setPassword("asadmin");
            userDetailsService.saveUser(token, "System Engineer");

            String[] uNameArr = {"alom", "mizan", "asad"};
            String[] passArr = {"alom123", "mizan123", "asad123"};
            String[] nameArr = {"Alomgir", "Mizanur Rahman", "Asaduzzaman"};
            for (int i = 0; i < nameArr.length; i++) {
                token = new Token();
                token.setUsername(uNameArr[i]);
                token.setPassword(passArr[i]);
                userDetailsService.saveUser(token, nameArr[i]);
                // adminService.saveEmployee(token, nameArr[i]);
            }


            User user = userDetailsService.findByUsername("account");
            List<Group> groups = initializeDefaultSecurityData();
            user.setGroupList(groups);

            userDetailsService.saveUser(user);
        }
    }

    @Override
    public boolean createComponents() {
        return false;
    }

    @Override
    public boolean createFeatures() {
        return false;
    }
}
