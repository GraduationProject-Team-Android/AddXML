package com.example.graduationproject.Kids_A7adith.API_kids;

import java.util.ArrayList;

public class Kids_json {
    private boolean status;
    private String errNum;
    private String msg;
    private ArrayList<Kids_A7adith_details> childhadiths;

    public ArrayList<Kids_A7adith_details> getChildhadiths() {
        return childhadiths;
    }

    public void setChildhadiths(ArrayList<Kids_A7adith_details> childhadiths) {
        this.childhadiths = childhadiths;
    }
    //  private ArrayList<String> childhadiths;
//
//    public ArrayList<String> getChildhadiths() {
//        return childhadiths;
//    }

//    public void setChildhadiths(ArrayList<String> childhadiths) {
//        this.childhadiths = childhadiths;
//    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getErrNum() {
        return errNum;
    }

    public void setErrNum(String errNum) {
        this.errNum = errNum;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
