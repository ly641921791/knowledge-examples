package com.github.ly641921791.spring.task.async.complex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author ly
 */
@SpringBootApplication
public class ComplexAsyncTaskApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(ComplexAsyncTaskApplication.class, args);
        applicationContext.getBean(ComplexAsyncTask.class).executeNormal();
        applicationContext.getBean(ComplexAsyncTask.class).executeException();
    }

}

