package com.oligizzz.mixueadmin.services.impl;

import com.oligizzz.mixueadmin.dao.SysUserDao;
import com.oligizzz.mixueadmin.pojo.User;
import com.oligizzz.mixueadmin.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServicesImpl implements UserServices {

//    @Autowired
//    SysUserDao userDao;
//
//    @Override
//    public User login(String username, String password) {
//        if (username == null || password == null) {
//            return null;
//        }
//        return userDao.selectUserByCondition(new User(null, username, password));
//    }
}
