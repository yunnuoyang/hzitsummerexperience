package com.struts.dao;

import com.struts.pojo.Chairman;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public void save(Chairman chairman){
        Session session = sessionFactory.openSession();
        Transaction tran = session.beginTransaction();
        session.save(chairman);
        tran.commit();
        session.close();

    }
}
