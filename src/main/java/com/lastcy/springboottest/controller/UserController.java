package com.lastcy.springboottest.controller;


import com.github.pagehelper.PageInfo;
import com.lastcy.springboottest.model.User;
import com.lastcy.springboottest.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("user")
@Api(value = "user Controller")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("根据id获取user")
    @GetMapping("getUser")
    public User gerUser(Integer id){
        User user = userService.getUserById(id);
        System.out.println("aaaa");
        return user;
    }

    @ApiOperation("添加user")
    @PostMapping("addUser")
    public int addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @ApiOperation("删除user")
    @GetMapping("delUser")
    public int delUser(Integer id){
        User param = new User();
        param.setId(id.longValue());
        return userService.delUser(param);
    }

    @ApiOperation("修改user")
    @PostMapping("modUser")
    public int modUser(@RequestBody User user){
        return userService.modUser(user);
    }

    @ApiOperation("获取user集合")
    @GetMapping("userList")
    public PageInfo<User> findUserList(Integer pageNum, Integer pageSize){
        pageNum = (pageNum == null || pageNum <= 0) ? 1 : pageNum;
        pageSize = (pageSize == null || pageSize <= 0) ? 20 : pageSize;
        return userService.findUserList(pageNum,pageSize);
    }
}
