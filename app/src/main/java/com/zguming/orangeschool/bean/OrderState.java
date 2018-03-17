package com.zguming.orangeschool.bean;

/**
 * Created by Administrator on 2018/3/1 0001.
 */
//更多订单状态
public class OrderState {
    String time;
    String no;
    public OrderState(String time,String no){
        this.time = time;
        this.no = no;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
}
