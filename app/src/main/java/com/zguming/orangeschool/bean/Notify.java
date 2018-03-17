package com.zguming.orangeschool.bean;

/**
 * Created by Administrator on 2018/2/23 0023.
 */
//商品
public class Notify {
    private String time;
    private String content;
    private String content2;

    public Notify(String time, String content,String content2) {
        this.time = time;
        this.content = content;
        this.content2 = content2;
    }

    public String getTime() {
        return time;
    }

    public String getContent() {
        return content;
    }

    public String getContent2() {
        return content2;
    }
}
