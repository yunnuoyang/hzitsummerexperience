package com.hibernate.pojo;

import javax.persistence.*;
import java.util.Objects;

public class GoodsEntity {
    private long id;
    private String goodsName;
    private double goodsPrice;
    private People people;

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsEntity that = (GoodsEntity) o;
        return id == that.id &&
                Double.compare(that.goodsPrice, goodsPrice) == 0 &&
                Objects.equals(goodsName, that.goodsName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, goodsName, goodsPrice);
    }
}
