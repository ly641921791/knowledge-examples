package com.github.ly641921791.spring.web.servlet.http.message.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

/**
 * @author ly
 */
@SpringBootApplication
public class HttpMessageConverterApplication {

    @Autowired
    private RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(HttpMessageConverterApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner() {
        return new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) throws Exception {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);

                HttpEntity request = new HttpEntity("{\"id\":1,\"name\":\"ly\"}", headers);

                System.out.println(restTemplate.postForObject("http://127.0.0.1:8080/print/user", request, String.class));

                headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_XML);

                request = new HttpEntity("<user><id>1</id><name>ly</name></user>", headers);

                System.out.println(restTemplate.postForObject("http://127.0.0.1:8080/print/user", request, String.class));
            }
        };
    }

}
