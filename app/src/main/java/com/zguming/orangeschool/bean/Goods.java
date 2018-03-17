package com.zguming.orangeschool.bean;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/2/23 0023.
 */
//商品
public class Goods {
    private String imageUrl;
    private String name;
    private String price;
    private String sales;

    public Goods(String name, String price, String sales) {
        this.name = name;
        this.price = price;
        this.sales = sales;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }
}
