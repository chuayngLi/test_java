package com.example.demotest.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demotest.bean.Note;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xx
 * @date 2024/4/1 11:17
 */
@Mapper
public interface NoteMapper extends BaseMapper<Note> {
}