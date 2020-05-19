package com.example.jwtdemo.mapper;

import com.example.jwtdemo.bean.Role;
import com.example.jwtdemo.bean.User;

import java.util.List;

/**
 * @author Piconjo
 * @date 2020/5/19  16:29
 */
public interface UserMapper {

    User findUserByUsername(String email);

    List<Role> findRoleByUsername(String email);

    int addUser(User user);
}
