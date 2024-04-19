package com.example.demotest.controller;

import com.example.demotest.bean.User;
import com.example.demotest.service.TestService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/test")
@ResponseBody
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @RequestMapping(value = "/upload/{fileName}", method = RequestMethod.GET)
    public Map<String, Object> upload(@PathVariable("fileName") String fileName, File file) throws IOException {
        Map<String, Object> map = new HashMap<>();
        String str = testService.upload(file);
        map.put("data", str);
        return map;
    }

    @RequestMapping(value = "/add/user", method = RequestMethod.GET)
    public Map<String, String> addUser(@Valid User user) {
        Map<String, String> map = new HashMap<>();
        String str = testService.addUser(user);
        map.put("data", str);
        return map;
    }

    @RequestMapping(value = "/ab", method = RequestMethod.GET)
    public String test() {
        return "audna";
    }

    /**
     * 创建文件测试
     */
    @RequestMapping(value = "/make/file", method = RequestMethod.GET)
    void make() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "b");
        String fileNameAndPath = ".a.txt.os";
        String content = map.toString();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileNameAndPath))) {
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}