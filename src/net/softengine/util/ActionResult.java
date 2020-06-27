package net.softengine.util;

import org.apache.commons.collections.MapUtils;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

public class ActionResult {
    private boolean success;

    private String msg;

    private Object dataObject;

    private Exception exception;

    private Map<String, String> errorMap = new HashMap<String, String>();

    private Map<String, Object> map = new HashMap<String, Object>();

    public Map<String, Object> getModelMap() {
        this.map.put("message", this.msg);
        this.map.put("success", this.success);
        return this.map;
    }

    public boolean hasMapValue() {
        return map != null && map.size() > 0;
    }

    public void put(String key, Object value) {
        map.put(key, value);
    }

    public Object get(String key) {
        return this.map.get(key);
    }

    public void putError(String fieldName, String message) {
        this.errorMap.put(fieldName, message);
    }

    public String getError(String fieldName) {
        return this.errorMap.get(fieldName);
    }

    public boolean hasError() {
        return !MapUtils.isEmpty(this.errorMap);
    }


    public ActionResult returnError(String fieldName, String message) {
        this.errorMap.put(fieldName, message);
        this.success = false;
        return this;
    }

    public ActionResult returnError(ActionResult result) {
        ActionResult actionResult = new ActionResult(false);
        actionResult.setErrorMap(result.getErrorMap());
        return actionResult;
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
        map.put("message", msg);
    }

    public ActionResult(boolean success, String msg) {
        map.put("message", msg);
        this.success = success;
        this.msg = msg;
    }

    public static ActionResult init() {
        return new ActionResult(false, "Sorry to Execute");
    }
    public static ActionResult init(boolean success) {
        return new ActionResult(success);
    }
    public static ActionResult init(boolean success, String msg) {
        return new ActionResult(success, msg);
    }

    public ActionResult(Boolean bool) {
        this.success = bool;
    }

    public Exception getException() {
        return exception;
    }

    public ActionResult exception(Exception exception) {
        this.setMsg(exception.getCause().getMessage());
        this.exception = exception;
        this.setSuccess(false);
        return this;
    }



    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public Map<String, String> getErrorMap() {
        return errorMap;
    }

    public void setErrorMap(Map<String, String> errorMap) {
        this.errorMap = errorMap;
    }
}