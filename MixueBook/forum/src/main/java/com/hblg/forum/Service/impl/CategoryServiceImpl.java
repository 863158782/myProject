package com.hblg.forum.Service.impl;

import com.hblg.forum.Entity.Category;
import com.hblg.forum.Mapper.CategoryMapper;
import com.hblg.forum.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> getAllCategory() {
        return categoryMapper.selectList(null);
    }
}
