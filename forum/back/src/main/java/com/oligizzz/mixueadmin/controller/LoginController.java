package com.oligizzz.mixueadmin.controller;

import com.oligizzz.mixueadmin.common.utils.Result;
import com.oligizzz.mixueadmin.pojo.User;
import com.oligizzz.mixueadmin.services.impl.UserServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;
import java.util.Objects;


@Controller
public class LoginController {
//    @Autowired
//    UserServicesImpl userServices;
//
//    @CrossOrigin
//    @PostMapping("api/login")
//    @ResponseBody
//    public Result login(@RequestBody User user, HttpSession session) {
//        String username = user.getUsername();
//        username = HtmlUtils.htmlEscape(username);
//        User dbUser = userServices.login(username, user.getPassword());
//        //简单的逻辑判断
//        if (dbUser==null) {
//            String msg = "用户名或者密码错误";
//            System.out.println(msg);
//            return new Result(400);
//        } else {
//            String msg = "登陆成功";
//            System.out.println("登陆成功！");
//            //前端保存用户状态
//            //session.setAttribute("user",user);
//            return new Result(200);
//        }
//
//    }
}
