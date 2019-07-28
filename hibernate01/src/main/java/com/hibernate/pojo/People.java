package com.hibernate.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * 用于正向工程的表
 */
public class People {
    private int id;
    private String name;
    private long year;

    private Set<GoodsEntity> goodsEntities=new HashSet<>();

    public Set<GoodsEntity> getGoodsEntities() {
        return goodsEntities;
    }

    public void setGoodsEntities(Set<GoodsEntity> goodsEntities) {
        this.goodsEntities = goodsEntities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }
}
