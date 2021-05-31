package com.example.chongbaostore.entity.data;

import android.app.Application;

import com.example.chongbaostore.entity.goods.Goods;

import java.util.ArrayList;
import java.util.List;

public class Data extends Application {
    private String username;
    private String userpwd;
    private String flag;
    private List<Goods> goodsList2 = new ArrayList<>();

    public List<Goods> getGoodsList2() {
        return goodsList2;
    }

    public void setGoodsList2(List<Goods> goodsList2) {
        this.goodsList2 = goodsList2;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
