package com.spring.day1.pojo;

public class ToyTwo implements PlayLife {
    private String name;
    private String type;

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public ToyTwo(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public void define() {
        System.out.println(name+type);
    }
}
