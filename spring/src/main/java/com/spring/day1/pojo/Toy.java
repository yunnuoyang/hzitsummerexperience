package com.spring.day1.pojo;

public class Toy implements PlayLife {
    private String name;
    private String type;

    public Toy(String name, String type) {
        this.name = name;
        this.type = type;
    }
    public void define(){
        System.out.println(name+type);
    }

    public Toy() {

    }

}
