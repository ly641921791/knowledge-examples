package com.github.ly641921791.spring.web.servlet.exception;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

/**
 * @author ly
 */
@SpringBootApplication
public class ExceptionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExceptionApplication.class);

        RestTemplate restTemplate = new RestTemplate();
        System.out.println(restTemplate.getForObject("http://127.0.0.1:8080/local/exception/execute",String.class));
        System.out.println(restTemplate.getForObject("http://127.0.0.1:8080/global/exception/execute",String.class));
    }

}
