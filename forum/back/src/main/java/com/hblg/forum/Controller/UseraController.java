package com.hblg.forum.Controller;

import com.hblg.forum.Entity.User;
import com.hblg.forum.Service.impl.UserServiceImpl;
import com.hblg.forum.until.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UseraController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("api/login")
    public Result Login(@RequestBody User user){
        Result result=new Result();
        if(userService.Login(user.getUsername(), user.getPassword())){
            result.setCode(200);
        }
        else{
            result.setCode(400);
        }
        return result;
    }

    @PostMapping("api/register")
    public Result Register(@RequestBody User user){
        Result result=new Result();
        if(userService.Register(user.getUsername(), user.getPassword())){
            result.setCode(200);
        }
        else{
            result.setCode(400);
        }
        return result;
    }
}
