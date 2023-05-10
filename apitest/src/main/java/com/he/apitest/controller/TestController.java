package com.he.apitest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author root
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return  "这是个测试";
    }
}
