package com.example.jwtdemo.service.impl;

import com.example.jwtdemo.bean.Role;
import com.example.jwtdemo.bean.User;
import com.example.jwtdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Piconjo
 * @date 2020/5/19  16:38
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if (s == null || "".equals(s))
        {
            throw new RuntimeException("用户不能为空");
        }
        // 调用方法查询用户
        User user = userMapper.findUserByUsername(s);
        if (user == null)
        {
            throw new RuntimeException("用户不存在");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role:userMapper.findRoleByUsername(s))
        {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),"{noop}"+user.getPassword(),authorities);
    }
}
