package com.example.graduationproject.Test.API_Test;

import java.util.List;

public class Get_Grades_json {
    private boolean status;
    private String errNum;
    private String msg;
    private List<Get_Grades_details> grades;

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

    public List<Get_Grades_details> getGrades() {
        return grades;
    }

    public void setGrades(List<Get_Grades_details> grades) {
        this.grades = grades;
    }

}
