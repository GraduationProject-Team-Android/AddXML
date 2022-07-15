package com.example.graduationproject.Test.API_Test;

import java.util.List;

public class Test_json {
    private boolean status;
    private String errNum;
    private String msg;
    private Ahadiths_Questions_details hadithsQuestion ;


    public Ahadiths_Questions_details getHadithsQuestion() {
        return hadithsQuestion;
    }
    public void setHadithsQuestion(Ahadiths_Questions_details hadithsQuestion) {
        this.hadithsQuestion = hadithsQuestion;
    }

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
