package net.softengine.util;

import net.softengine.constant.SecurityConstants;
import net.softengine.security.SessionUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by khomeni404 on 11/4/2016.
 */
public interface ActionUtil {

    static Map<String, Object> getModelMap(String pageTitle) {
        Map<String, Object> map = new HashMap<>();
        map.put("DashBoardLink", SecurityConstants.DASHBOARD_LINK);
        map.put("PageTitle", pageTitle == null ? "SE" : pageTitle);
        map.put("SU", new SessionUtil());
        map.put("DU", new DateUtil());
        map.put("SEU", new SEUtil());
        //map.put("QC", new QRFConstant());
        return map;
    }
}
