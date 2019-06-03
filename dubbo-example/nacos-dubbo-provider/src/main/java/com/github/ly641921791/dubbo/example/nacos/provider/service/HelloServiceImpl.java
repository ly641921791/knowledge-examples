package com.github.ly641921791.dubbo.example.nacos.provider.service;

import com.github.ly641921791.dubbo.example.common.service.HelloService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author ly
 **/
@Service(version = "${dubbo.service.version}")
public class HelloServiceImpl implements HelloService {

    @Value("${spring.application.name}")
    private String serviceName;

    public String sayHello(String name) {
        return String.format("[%s] : Hello , %s", serviceName, name);
    }

}
