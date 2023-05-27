package com.hblg.forum.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hblg.forum.Mapper.UserMapper;
import com.hblg.forum.Service.USerService;
import com.hblg.forum.until.Result;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import com.hblg.forum.Entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements USerService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User Login(String username,String password) {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getUsername,username);
        queryWrapper.lambda().eq(User::getPassword,password);
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public User findUserByID(long id) {

        return userMapper.selectById(id);
    }

    @Override
    public boolean Register(String username, String password) {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getUsername,username);
        boolean flag= userMapper.selectOne(queryWrapper)==null?false:true;
        if(flag){
            return false;
        }
        else{
            User user=new User();
            user.setUsername(username);
            user.setPassword(password);
            userMapper.insert(user);
            return true;
        }

    }
}
