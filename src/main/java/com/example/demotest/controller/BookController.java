package com.example.demotest.controller;

import com.example.demotest.bean.Book;
import com.example.demotest.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/book")
@ResponseBody
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map<String, Object> list(String query, Integer current, Integer size) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", bookService.list(query, current, size));
        return map;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map<String, String> add(@Valid Book book) {
        Map<String, String> map = new HashMap<>();
        map.put("msg", bookService.add(book) != 1 ? "添加失败" : "添加成功");
        return map;
    }

    @RequestMapping(value = "/del/{bookId}", method = RequestMethod.POST)
    public Map<String, String> del(@PathVariable("bookId") Long bookId) {
        Map<String, String> map = new HashMap<>();
        map.put("msg", bookService.del(bookId) != 1 ? "删除失败" : "删除成功");
        return map;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Map<String, String> update(@Valid Book book) {
        Map<String, String> map = new HashMap<>();
        map.put("msg", bookService.update(book) != 1 ? "修改失败" : "修改成功");
        return map;
    }

}
