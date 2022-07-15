package com.example.graduationproject.Test.API_Test;

import java.util.List;

public class Ahadith_Level_json {
private boolean status ;
private String errNum ;
private String msg ;
private List<Ahadith_Level_details> levelHadiths ;


    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getErrNum() {
        return errNum;
    }

    public List<Ahadith_Level_details> getLevelHadiths() {
        return levelHadiths;
    }

    public void setLevelHadiths(List<Ahadith_Level_details> levelHadiths) {
        this.levelHadiths = levelHadiths;
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
