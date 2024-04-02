package com.example.demotest.controller;

import com.example.demotest.bean.User;
import com.example.demotest.service.TestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/test")
@ResponseBody
public class TestController {
    @Autowired
    private TestService testService;

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

}