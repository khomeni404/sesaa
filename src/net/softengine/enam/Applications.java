/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.softengine.enam;

import net.softengine.util.DateUtil;

import java.util.Date;

/**
 * @author Khomeni
 */
public enum Applications {

    MIRROR_DPL(11, "MIRROR", "", "", "30-12-2017", "DORPAN Properties Ltd.", "Real Estate"),
    ePDM_BRTC_BUET(12, "ePDM", "", "", "30-01-2017", "Bureau of Research, Testing & Consultation", ""),
    eVISION_FVPL(13, "eVision", "", "", "28-12-2020", "Fair Vision Property & Society Ltd.", ""),
    CHAMBER(14, "CHAMBER", "", "", "28-12-2016", "", "Simple Chamber Management System"),
    eSHOP(15, "eShop", "", "", "28-12-2017", "", "Simple ERP System"),
    QRF(16, "QRF", "", "", "28-12-2016", "", "ERP System for Quran Research Foundation.");

    public final Integer CODE;          // Application Code
    public final String NAME;           // Application Name
    public final String R_DATE;         // Release Date
    public final String R_NOTE;         // Release Note
    public final String V_DATE;         // Valid Date
    public final String STAKE_HOLDER;   // Stakeholder
    public final String DESCRIPTION;    // Description

    Applications(Integer code, String name, String rDate, String rNote, String vDate, String sHolder, String description) {
        CODE = code;
        NAME = name;
        R_DATE = rDate;
        R_NOTE = rNote;
        V_DATE = vDate;
        STAKE_HOLDER = sHolder;
        DESCRIPTION = description;
    }

    public static void main(String[] args) {
        System.out.println(Applications.CHAMBER.DESCRIPTION);
    }

    /**
     * This method returns application dead line Date
     *
     * @param APP Applications
     * @return Date date
     */
    public static Date getExpiryDate(Applications APP) {
        return DateUtil.toDate(APP.V_DATE, "dd-MM-yyyy");
    }
}
