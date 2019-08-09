package com.disk.intercepter.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
public class SessionAop {
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction tran;
    public SessionAop() {
    }

    public Session openSession(){
        System.out.println("=================SessionAop===============");
        session=sessionFactory.openSession();
         tran= session.beginTransaction();
        return session;
    }
    public void commitAndClose(){
        System.out.println("=================SessionAop.commitAndClose===============");
        tran.commit();
        session.close();
    }
}
