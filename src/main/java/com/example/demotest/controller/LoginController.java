package com.example.demotest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author xx
 * @date 2024/4/10 9:40
 */
@RestController
@ResponseBody
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Map<String, Object> login(String account, String password) {
        return null;
    }
}