package com.hibernate.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "goods", schema = "demo", catalog = "")
public class GoodsEntity {
    private long id;
    private String goodsName;
    private double goodsPrice;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "goods_name")
    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    @Basic
    @Column(name = "goods_price")
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
