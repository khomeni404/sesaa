package net.softengine.constant;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Khomeni
 */
public interface SEConstants {
    String DASHBOARD_LINK = "../home/home.se";
    List<String> MONTH_LIST = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");

    public static final Integer DOC_TYPE_TYPE_PROFILE_PIC = 0;
    public static final Integer DOC_TYPE_TYPE_SIGNATURE = 1;
    public static final Integer DOC_TYPE_TYPE_DOCUMENT = 2;
    public static final List<String> DOC_TYPE_TYPE_LIST = new ArrayList<String>() {{
        add(DOC_TYPE_TYPE_PROFILE_PIC, "Profile Picture");
        add(DOC_TYPE_TYPE_SIGNATURE, "Signature");
        add(DOC_TYPE_TYPE_DOCUMENT, "Document");
    }};
}
