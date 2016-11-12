package net.softengine.security.service;

import net.softengine.security.model.Group;

import java.util.List;

/**
 * Copyright &copy; Soft Engine Inc.
 * Created on 13/05/16
 * Created By : Khomeni
 * Edited By : Khomeni &
 * Last Edited on : 13/05/16
 * Version : 1.0
 */

public interface ConfigureService {
    public List<Group> initializeDefaultSecurityData();

    public void createDefaultAdmin();

    public boolean createComponents();

    public boolean createFeatures();
}
