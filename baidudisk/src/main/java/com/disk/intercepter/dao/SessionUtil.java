package com.disk.intercepter.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SessionUtil {
    @Autowired
    private SessionFactory sessionFactory;
    private static Session session;
    private static Transaction tran;
    public Session getSession(){
        session = sessionFactory.openSession();
        tran=session.beginTransaction();
        return session;
    }
    public  void close(){
        tran.commit();
        session.close();
    }
}
