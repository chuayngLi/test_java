package com.example.demotest.controller;

import com.example.demotest.bean.Issue;
import com.example.demotest.service.IssueService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/issue")
@ResponseBody
public class IssueController {
    private final IssueService issueService;

    @Autowired
    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Map<String, Object> list(@Valid String query, Integer current, Integer size) {
        Map<String, Object> map = new HashMap<>();
        map.put("data", issueService.list(query, current, size));
        return map;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Map<String, String> add(@Valid @RequestBody Issue issue) {
        Map<String, String> map = new HashMap<>();
        map.put("msg", issueService.add(issue) != 1 ? "添加失败" : "添加成功");
        return map;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Map<String, String> update(@Valid @RequestBody Issue issue) {
        Map<String, String> map = new HashMap<>();
        map.put("msg", issueService.update(issue) != 1 ? "编辑失败" : "编辑成功");
        return map;
    }

    @RequestMapping(value = "/del/{issueId}", method = RequestMethod.POST)
    public Map<String, String> del(@PathVariable("issueId") Integer issueId) {
        Map<String, String> map = new HashMap<>();
        map.put("msg", issueService.del(issueId) != 1 ? "删除失败" : "删除成功");
        return map;
    }
}
