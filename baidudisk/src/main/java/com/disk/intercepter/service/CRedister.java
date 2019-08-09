package com.disk.intercepter.service;

import com.disk.intercepter.dao.NetUserDao;
import com.disk.intercepter.pojo.Netuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CRedister implements IRegister {
    @Autowired
    private NetUserDao ud;

    @Override
    public void saveNetUser(Netuser netuser) {

        ud.saveNetUser(netuser);
    }

    @Override
    public boolean checkUser(String username) {
        return  ud.checkUser(username);
    }

    @Override
    public Netuser isExit(Netuser nu, String loginName) {
        Netuser netuser=ud.getUser(loginName,nu);
            if(netuser!=null)
                return netuser;
            return null;
    }
}
