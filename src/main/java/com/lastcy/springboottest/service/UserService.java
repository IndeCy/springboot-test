package com.lastcy.springboottest.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lastcy.springboottest.dao.UserHandler;
import com.lastcy.springboottest.dao.UserMapper;
import com.lastcy.springboottest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserHandler userHandler;

    private final String USER_KEY = "user::";

    @Cacheable(value = "user",key ="#id")
    public User getUserById(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }


    @CachePut(value = "user",key = "#user.id")
    public int addUser(User user){
        userHandler.addUser(user);
        return user.getId().intValue();
    }

    @CacheEvict(value = "user",key = "#user.id")
    public int delUser(User user){
        return userMapper.delete(user);
    }

    @CachePut(value = "user",key = "#user.id")
    public int modUser(User user){
        return userMapper.updateByPrimaryKey(user);
    }

    public PageInfo<User> findUserList(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(userMapper.selectAll());
    }

}
