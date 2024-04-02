package com.example.demotest.controller;

import com.example.demotest.bean.Note;
import com.example.demotest.service.NoteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xx
 * @date 2024/4/1 10:40
 */
@RestController
@RequestMapping(value = "/note")
@ResponseBody
public class NoteController {
    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map<String, Object> list(@Valid @RequestParam String query, Integer current, Integer size) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", noteService.list(query, current, size));
        return map;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map<String, String> add(@Valid Note note) {
        Map<String, String> map = new HashMap<>();
        map.put("msg", noteService.add(note) != 1 ? "添加失败" : "添加成功");
        return map;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Map<String, String> update(@Valid Note note) {
        Map<String, String> map = new HashMap<>();
        map.put("msg", noteService.update(note) != 1 ? "修改失败" : "修改成功");
        return map;
    }

    @RequestMapping(value = "/del/{noteId}", method = RequestMethod.POST)
    public Map<String, String> delete(@Valid @PathVariable("noteId") Long noteId) {
        Map<String, String> map = new HashMap<>();
        map.put("msg", noteService.delete(noteId) != 1 ? "删除失败" : "删除成功");
        return map;
    }

    @RequestMapping(value = "/info/{noteId}", method = RequestMethod.POST)
    public Map<String, Note> info(@Valid @PathVariable("noteId") Long noteId) {
        Map<String, Note> map = new HashMap<>();
        map.put("data", noteService.Info(noteId));
        return map;
    }

}