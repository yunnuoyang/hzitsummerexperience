package com.disk.intercepter.dao;

import com.disk.intercepter.pojo.Netuser;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NetUserDao {
    @Autowired
    private SessionUtil sessionUtil;
    public void saveNetUser(Netuser netuser) {
        Session session = sessionUtil.getSession();
        session.save(netuser);
        sessionUtil.close();
    }

    public boolean checkUser(String username) {
        Session session = sessionUtil.getSession();
        Netuser netuser = session.get(Netuser.class, username);
        if(netuser!=null){
            sessionUtil.close();
            return true;
        }
        sessionUtil.close();
        return false;
    }

    public Netuser getUser(String loginName, Netuser nu) {
        Session session = sessionUtil.getSession();
        NativeQuery sqlQuery = session.createSQLQuery("select" +
                " username,password,usertype,email,activeCode " +
                " from netuser where username=:username or email=:email and password=:password");
        sqlQuery.setParameter("username",loginName);
        sqlQuery.setParameter("email",loginName);
        sqlQuery.setParameter("password",nu.getPassword());
        List<Object[]> list = sqlQuery.list();
        Netuser netuser=new Netuser();

        if( list.size()>0){
            Object[] objects = list.get(0);
            netuser.setUsername((String) objects[0]);
            netuser.setPassword((String) objects[1]);
            netuser.setEmail((String) objects[2]);
            netuser.setActiveCode((String) objects[3]);
            return netuser;
        }
        sessionUtil.close();
        return null;

    }
}
