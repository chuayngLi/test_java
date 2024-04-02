package com.example.demotest.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demotest.bean.Book;
import com.example.demotest.bean.Note;
import com.example.demotest.dao.BookMapper;
import com.example.demotest.dao.NoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author xx
 * @date 2024/4/1 11:16
 */
@Service
public class NoteService {
    private final NoteMapper noteMapper;

    private final BookMapper bookMapper;

    @Autowired
    public NoteService(NoteMapper noteMapper, BookMapper bookMapper) {
        this.noteMapper = noteMapper;
        this.bookMapper = bookMapper;
    }

    public Page<Note> list(String query, Integer current, Integer size) {
        LambdaQueryWrapper<Note> noteLambdaQueryWrapper = Wrappers.lambdaQuery();
        if (!Objects.equals(query, ""))
            noteLambdaQueryWrapper.like(Note::getTitle, query).or().like(Note::getContent, query);
        noteLambdaQueryWrapper.orderByDesc(Note::getCreatedAt);
        Page<Note> notePage = new Page<>(current, size);
        return noteMapper.selectPage(notePage, noteLambdaQueryWrapper);
    }

    public Integer add(Note note) {
        if (!checkBookById(note.getBookId()) || !checkBookByName(note.getBookName())) {
            return 0;
        }
        return noteMapper.insert(note);
    }

    public Integer update(Note note) {
        if (!checkBookById(note.getBookId()) || !checkBookByName(note.getBookName())) {
            return 0;
        }
        return noteMapper.updateById(note);
    }

    public Note Info(Long noteId) {
        return noteMapper.selectById(noteId);
    }

    public Integer delete(Long id) {
        return noteMapper.deleteById(id);
    }

    /**
     * 确定book是否存在
     * 根据id或name去判断
     */
    private Boolean checkBookById(Long bookId) {
        Book book = bookMapper.selectById(bookId);
        return book != null;
    }

    private Boolean checkBookByName(String name) {
        LambdaQueryWrapper<Book> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Book::getName, name);
        Book book = bookMapper.selectOne(lambdaQueryWrapper);
        return book != null;
    }
}