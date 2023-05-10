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
    public boolean Login(String username,String password) {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getUsername,username);
        queryWrapper.lambda().eq(User::getPassword,password);
        return userMapper.selectList(queryWrapper)==null?false:true;
    }
}
