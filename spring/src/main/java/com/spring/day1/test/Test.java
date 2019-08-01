package com.spring.day1.test;

import com.spring.day1.pojo.Component;
import com.spring.day1.pojo.LinkComponent;
import com.spring.day1.pojo.StaticObject;
import demo01.Ink;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    @org.junit.Test
    public  void test1(){
        //父容器
        ClassPathXmlApplicationContext parent=new ClassPathXmlApplicationContext("spring.xml");
        //将子容器绑定给父容器
        ClassPathXmlApplicationContext child=new ClassPathXmlApplicationContext(new String[]{"spring1.xml"},parent);
        ApplicationContext parent1 = child.getParent();
        System.out.println(parent.hashCode()+"======"+parent1.hashCode());
        Ink ink = (Ink) parent1.getBean("ink");
        ink.print();
    }
    @org.junit.Test
    public  void test2(){
        //父容器
        ClassPathXmlApplicationContext parent=new ClassPathXmlApplicationContext("spring.xml");
        //将子容器绑定给父容器
        ClassPathXmlApplicationContext child=new ClassPathXmlApplicationContext(new String[]{"spring1.xml"},parent);
        ApplicationContext parent1 = child.getParent();
        System.out.println(parent.hashCode()+"======"+parent1.hashCode());
        Component component = (Component) child.getBean("component");
        System.out.println(component);
    }
    @org.junit.Test
    public  void test3(){
        //父容器
        ClassPathXmlApplicationContext parent=new ClassPathXmlApplicationContext("spring.xml");
        //将子容器绑定给父容器
        ClassPathXmlApplicationContext child=new ClassPathXmlApplicationContext(new String[]{"spring1.xml"},parent);
        ApplicationContext parent1 = child.getParent();
        LinkComponent linkComponent = (LinkComponent) child.getBean("linkComponent");
        System.out.println(linkComponent.getComponent());
    }
    @org.junit.Test
    public  void test4(){
        //父容器
        ClassPathXmlApplicationContext parent=new ClassPathXmlApplicationContext("spring.xml");
        //将子容器绑定给父容器
        ClassPathXmlApplicationContext child=new ClassPathXmlApplicationContext(new String[]{"spring1.xml"},parent);
        ApplicationContext parent1 = child.getParent();
        child.getBean("staticObject");
    }
    @org.junit.Test
    public void test5(){
        ClassPathXmlApplicationContext parent=new ClassPathXmlApplicationContext("applicationContext.xml");

    }
}
