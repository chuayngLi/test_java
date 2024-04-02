package com.example.demotest.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demotest.bean.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper extends BaseMapper<Book> {
}
