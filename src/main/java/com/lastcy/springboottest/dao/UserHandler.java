package com.lastcy.springboottest.dao;

import com.lastcy.springboottest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserHandler {

    @Autowired
    private UserMapper userMapper;

    public int addUser(User user){
        userMapper.insert(user);
        return user.getId().intValue();
    }
}
