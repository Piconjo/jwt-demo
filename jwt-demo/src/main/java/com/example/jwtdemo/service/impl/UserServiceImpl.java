package com.example.jwtdemo.service.impl;

import com.example.jwtdemo.bean.User;
import com.example.jwtdemo.mapper.RoleMapper;
import com.example.jwtdemo.mapper.UserMapper;
import com.example.jwtdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Piconjo
 * @date 2020/5/19  16:25
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public int addUser(User user) {
        roleMapper.addRole(user.getUsername(),"USER");
        return userMapper.addUser(user);
    }
}
