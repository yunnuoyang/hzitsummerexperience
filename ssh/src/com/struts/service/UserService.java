package com.struts.service;

import com.struts.dao.UserDao;
import com.struts.pojo.Chairman;
import com.struts.pojo.User;

public class UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    public void save(Chairman chairman){
        userDao.save(chairman);
    }
}
