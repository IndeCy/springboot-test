package com.lastcy.springboottest.dao;

import com.lastcy.springboottest.model.User;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
