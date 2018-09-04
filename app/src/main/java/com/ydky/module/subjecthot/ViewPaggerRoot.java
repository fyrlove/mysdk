package com.ydky.module.subjecthot;
import java.util.ArrayList;
import java.util.List;

public class ViewPaggerRoot {

    private int code;
    private int min_id;
    private String msg;
    private ArrayList<Data> data;
    public void setCode(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }

    public void setMin_id(int min_id) {
        this.min_id = min_id;
    }
    public int getMin_id() {
        return min_id;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
    }
    public ArrayList<Data> getData() {
        return data;
    }

}