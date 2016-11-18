package net.softengine.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ActionResult {
    private boolean success;

    private String msg;

    private Object dataObject;

    private Exception exception;

    private Map<String, Object> map = new HashMap<>();

    public boolean hasMapValue() {
        return map != null && map.size() > 0;
    }

    public void put(String key, Object value) {
        map.put(key, value);
    }

    public Object get(String key) {
        return map.get(key);
    }

    public Object getDataObject() {
        return this.dataObject;
    }

    public void setDataObject(Object dataObject) {
        this.dataObject = dataObject;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public ActionResult(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public ActionResult(Boolean bool) {
        this.success = bool;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}