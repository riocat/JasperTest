package com.yang.ireport.model;

import java.io.Serializable;

/**
 * Created by ASUS on 2017/7/30.
 */
public class Repertory implements Serializable {

    private String objuid;
    private String repertoryCode;
    private String repertoryName;
    private String specialCode;

    public String getObjuid() {
        return objuid;
    }

    public void setObjuid(String objuid) {
        this.objuid = objuid;
    }

    public String getRepertoryCode() {
        return repertoryCode;
    }

    public void setRepertoryCode(String repertoryCode) {
        this.repertoryCode = repertoryCode;
    }

    public String getRepertoryName() {
        return repertoryName;
    }

    public void setRepertoryName(String repertoryName) {
        this.repertoryName = repertoryName;
    }

    public String getSpecialCode() {
        return specialCode;
    }

    public void setSpecialCode(String specialCode) {
        this.specialCode = specialCode;
    }
}
