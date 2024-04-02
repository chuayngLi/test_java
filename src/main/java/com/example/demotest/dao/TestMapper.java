package com.example.demotest.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demotest.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper extends BaseMapper<User> {
}
