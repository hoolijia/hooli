package com.hooli.web.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController2 {

    @RequestMapping("test2")
    public void test() {
        System.out.println("test2");
    }
}
