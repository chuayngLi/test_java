package com.example.demotest.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demotest.bean.Book;
import com.example.demotest.dao.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BookService {
    private final BookMapper bookMapper;

    @Autowired
    public BookService(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public int add(Book book) {
        return bookMapper.insert(book);
    }

    public int del(Long bookId) {
        return bookMapper.deleteById(bookId);
    }

    public Page<Book> list(String query, Integer current, Integer size) {
        LambdaQueryWrapper<Book> bookLambdaQueryWrapper = Wrappers.lambdaQuery();
        if (!Objects.equals(query, ""))
            bookLambdaQueryWrapper.like(Book::getName, query).or().like(Book::getType, query);
        bookLambdaQueryWrapper.orderByDesc(Book::getCreatedAt);
        Page<Book> bookPage = new Page<>(current, size);
        return bookMapper.selectPage(bookPage, bookLambdaQueryWrapper);
    }

    public int update(Book book) {
        return bookMapper.updateById(book);
    }
}
