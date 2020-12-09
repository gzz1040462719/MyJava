package com.cykj.bean;

import com.google.gson.Gson;

import java.util.List;

public class LayuiReplay <T> {
    private int code;//状态
    private String msg;//提示消息
    private int count;//发送总数
    private List<T> data;

    public LayuiReplay(int code, String msg, int count, List<T> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public String toJson() {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }

//    public static <T> String toJson(int count, List<T> data) {
//        LayuiReplay<T> replay = new LayuiReplay<>(ReplyCode.OK.getCode(), ReplyCode.OK.getMessage(), count, data);
//        return replay.toJson();
//    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}