package com.github.ly641921791.example.nacos.spring.cloud.discovery.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ly
 */
@RestController
public class HelloController {

    @Value("${spring.application.name}")
    private String serviceName;

    @RequestMapping("/hello/{name}")
    public String sayHello(@PathVariable String name) {
        return String.format("[%s] : Hello , %s", serviceName, name);
    }

}
