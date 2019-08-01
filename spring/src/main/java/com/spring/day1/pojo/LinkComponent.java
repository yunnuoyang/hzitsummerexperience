package com.spring.day1.pojo;

/**
 * 引用Component的属性
 */
public class LinkComponent {
    private Component component;

    public void setComponent(Component component) {
        this.component = component;
    }

    public Component getComponent() {
        return component;
    }
}
