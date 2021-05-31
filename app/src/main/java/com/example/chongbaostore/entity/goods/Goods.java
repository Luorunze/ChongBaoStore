package com.example.chongbaostore.entity.goods;

public class Goods {
    private String price;
    private String name;
    private int photo;

    public Goods(String price, String name, int photo) {
        this.price = price;
        this.name = name;
        this.photo = photo;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "price='" + price + '\'' +
                ", name='" + name + '\'' +
                ", photo=" + photo +
                '}';
    }
}
