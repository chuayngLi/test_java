package com.example.demotest.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demotest.bean.Issue;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IssueMapper extends BaseMapper<Issue> {
}
