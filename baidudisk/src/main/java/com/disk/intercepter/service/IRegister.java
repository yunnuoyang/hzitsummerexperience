package com.disk.intercepter.service;

import com.disk.intercepter.pojo.Netuser;

public interface IRegister {
    void saveNetUser(Netuser netuser);

    boolean checkUser(String username);

    Netuser isExit(Netuser nu, String loginName);
}
