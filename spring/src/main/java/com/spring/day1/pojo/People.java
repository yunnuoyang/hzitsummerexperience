package com.spring.day1.pojo;

/**
 * spring 的构造器注入方式优先通过byName的方式在上下文中找到相应的bean
 * 找不到的话，通过ByType的方式进行匹配
 */
public class People {
    private String name;
    private Toy toy;

    public People(Toy toy) {
        this.toy = toy;
    }

    public People() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setToy(Toy toy) {
        this.toy = toy;
    }

    public String getName() {
        return name;
    }

    public void play() {
        toy.define();
    }
}
