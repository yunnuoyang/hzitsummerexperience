package com.hibernate.pojo;

/**
 * 用于正向工程的表
 */
public class People {
    private int id;
    private String name;
    private long year;

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
