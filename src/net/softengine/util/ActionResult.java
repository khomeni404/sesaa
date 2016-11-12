package net.softengine.util;

import java.awt.print.Book;

public class ActionResult {
    private boolean success;

    private String msg;

    private Object dataObject;

    private Exception exception;

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
}