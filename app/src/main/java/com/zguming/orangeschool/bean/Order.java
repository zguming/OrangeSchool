package com.zguming.orangeschool.bean;

/**
 * Created by Administrator on 2018/2/24 0024.
 */
//订单
public class Order {
    private String no;
    private String time;
    private String imgUrl;
    private String num;
    private String price;

    public Order(String no, String time, String imgUrl, String num, String price) {
        this.no = no;
        this.time = time;
        this.imgUrl = imgUrl;
        this.num = num;
        this.price = price;

    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
