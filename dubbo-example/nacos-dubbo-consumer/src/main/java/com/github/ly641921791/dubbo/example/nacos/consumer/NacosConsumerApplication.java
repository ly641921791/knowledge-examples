package com.github.ly641921791.dubbo.example.nacos.consumer;

import com.github.ly641921791.dubbo.example.common.service.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author ly
 **/
@SpringBootApplication
public class NacosConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerApplication.class, args).close();
    }

    @Reference(version = "${dubbo.service.version}")
    private HelloService helloService;

    @Bean
    public ApplicationRunner runner() {
        return new ApplicationRunner() {
            public void run(ApplicationArguments args) throws Exception {
                System.out.println(helloService.sayHello("consumer"));
            }
        };
    }

}
