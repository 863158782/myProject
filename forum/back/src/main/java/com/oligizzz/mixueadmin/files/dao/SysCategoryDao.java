package com.oligizzz.mixueadmin.dao;


import com.oligizzz.mixueadmin.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface SysCategoryDao {

    /**
     * 获取所有书籍类别
     * @return
     */
    List<Category> selectAll();

    /**
     * 通过Id查询指定类别
     * @param id
     * @return
     */
    Category selectCategoryById(Integer id);
}
