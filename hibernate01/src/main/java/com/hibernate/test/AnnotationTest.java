package com.hibernate.test;

import com.hibernate.pojo.Fish;
import org.hibernate.Session;
import org.junit.Test;

public class AnnotationTest {
    @Test
    public void test(){
        Session session = HibernateUtils.getSession();
        Fish fish = session.get(Fish.class, 1);
        System.out.println(fish.getUserName()+""+fish.getPassWord());
        session.close();
    }
}
