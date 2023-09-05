package com.pan.docker.secret.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2023/9/4 14:23
 */
@RestController
public class TestController {
    private String token;
//    @Value("${docker-secret-openatc-token:}")
    @GetMapping("")
    public void test() {
        System.out.println("test");
    }
}
