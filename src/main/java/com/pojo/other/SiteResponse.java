package com.pojo.other;

import java.util.HashMap;

public class SiteResponse {
    public HashMap<String, Object> map = new HashMap<>();
    public String msg;
    public Boolean state;

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public HashMap<String, Object> getMap() {

        return map;
    }

    public void setMap(HashMap<String, Object> map) {
        this.map = map;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
