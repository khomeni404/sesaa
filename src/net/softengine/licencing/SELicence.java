package net.softengine.licencing;

import net.softengine.enam.Applications;
import net.softengine.util.ActionResult;
import net.softengine.util.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SELicence {
    public static final SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");
    public Applications application;
    private static final  String VALIDITY_MESSAGE = "Sorry<hr/>\n" +
            "Limited <span class=\"text-danger\"> ACCESS</span> or <span class=\"text-danger\"> UNAUTHORIZED USE</span> of code. <br/>\n" +
            "Email to khomeni404@gmail.com for more information. <br/>\n" +
            "www.soft-engine.net";
            //"\nValidity date was "+Applications.getExpiryDate(Applications.CHAMBER);

    private static final String PROJECT_RANGE_MSG = "Maximum limit crossed<hr/>\n" +
            "Email to khomeni404@gmail.com for more information. <br/>\n" +
            "www.soft-engine.net";

    public static ActionResult checkLicenceValidity(Applications app) {
        Date limitDate = Applications.getExpiryDate(app);
        ActionResult res = new ActionResult(false);
        Date today = new Date();
        if (today.compareTo(limitDate) > 0) {
            res.setMsg(VALIDITY_MESSAGE);
        } else {
            res.setMsg("License limited to Date : "+limitDate);
            res.setSuccess(true);
        }
        return res;
    }



    public static ActionResult checkProjectsRange() {
        return null;
    }

}
