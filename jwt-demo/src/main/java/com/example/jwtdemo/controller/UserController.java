package com.example.jwtdemo.controller;

import com.example.jwtdemo.bean.User;
import com.example.jwtdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Piconjo
 * @date 2020/5/19  16:25
 */

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册
     * @param user
     * @return
     */
    @PostMapping("/register")
    public String register(User user){
        userService.addUser(user);
        return "success";
    }

    /**
     * 测试接口 - 需要相应权限
     * @return
     */
    @GetMapping("/data")
    public String data()
    {
        return "success";
    }

}
