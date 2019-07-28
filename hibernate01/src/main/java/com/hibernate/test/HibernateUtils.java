package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    public static Session getSession(){
        Configuration cfg=new Configuration().configure();
        Session session= cfg.buildSessionFactory().openSession();
        return session;
    }
}
