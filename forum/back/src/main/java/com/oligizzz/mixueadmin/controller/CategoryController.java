package com.oligizzz.mixueadmin.controller;

import com.oligizzz.mixueadmin.common.utils.Result;
import com.oligizzz.mixueadmin.services.impl.CategoryServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @Autowired
    CategoryServicesImpl categoryServicesImpl;

    @GetMapping("api/category")
    public Result getCategory(){

        return  new Result(categoryServices.getAllCategory());
    }
}
