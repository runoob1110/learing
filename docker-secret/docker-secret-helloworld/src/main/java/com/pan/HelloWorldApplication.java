package com.pan;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2023/9/4 10:43
 */
@SpringBootApplication
public class HelloWorldApplication implements CommandLineRunner {
    private String password;
    @Value("${USERNAME_FILE:}")
    private String username;
    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApplication.class, args);
    }

    @Value("${docker-secret-openatc-token:}")
    public void setCustomMsg(String password) {
        if (StringUtils.hasLength(password)) {
            this.password = password;
        }
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println(password);
        System.out.println(username);
    }
}
