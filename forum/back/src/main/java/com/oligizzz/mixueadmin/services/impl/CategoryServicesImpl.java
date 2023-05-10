package com.oligizzz.mixueadmin.services.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.oligizzz.mixueadmin.mapper.CategoryMapper;
import com.oligizzz.mixueadmin.pojo.Category;
import com.oligizzz.mixueadmin.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



public class CategoryServicesImpl implements CategoryServices {
//    @Autowired
//    SysCategoryDao syscategoryDao;

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> getAllCategory() {
        QueryWrapper<User> queryWrapper=new QueryWrapper<User>();

        List<Category> list=categoryMapper.selectOne("");
        return list;
    }

//    @Override
//    public List<Category> getAllCategory() {
//        return syscategoryDao.selectAll();
//    }
//
//    @Override
//    public Category getCategoryById(Integer id) {
//        return syscategoryDao.selectCategoryById(id);
//    }


}
