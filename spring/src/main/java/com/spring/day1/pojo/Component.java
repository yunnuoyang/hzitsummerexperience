package com.spring.day1.pojo;

import java.util.*;

/**
 * 测试spring的集合注入
 */
public class Component {
    private List list;
    private Set set;
    private Map map;
    private Properties properties;
    String [] array;

    public void setList(List list) {
        this.list = list;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    @Override
    public String toString() {
        return "Component{" +
                "list=" + list +
                ", set=" + set +
                ", map=" + map +
                ", properties=" + properties +
                ", array=" + Arrays.toString(array) +
                '}';
    }

}
