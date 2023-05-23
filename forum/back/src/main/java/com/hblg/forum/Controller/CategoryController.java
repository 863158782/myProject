package com.hblg.forum.Controller;


import com.hblg.forum.Service.impl.CategoryServiceImpl;
import com.hblg.forum.until.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    CategoryServiceImpl categoryServiceImpl;

    @GetMapping("/getCategory")
    public Result getAllCategory(){
        Result result=new Result();
        result.setCode(200);
        result.setData(categoryServiceImpl.getAllCategory());
        return result;
    }
}
