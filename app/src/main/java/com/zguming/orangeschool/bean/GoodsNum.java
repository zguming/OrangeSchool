package com.zguming.orangeschool.bean;

/**
 * Created by Administrator on 2018/3/20 0020.
 */
//用于GoodsDetail与HomeFragment之间的数值（购物车商品数目）传递
public class GoodsNum {
    private static int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        GoodsNum.num = num;
    }
}
