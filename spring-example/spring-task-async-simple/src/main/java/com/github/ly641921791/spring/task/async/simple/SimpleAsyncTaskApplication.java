package com.github.ly641921791.spring.task.async.simple;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author ly
 */
@Slf4j
@EnableAsync
@SpringBootApplication
public class SimpleAsyncTaskApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SimpleAsyncTaskApplication.class, args);
        log.info("【程序启动】当前线程：{}", Thread.currentThread().getName());
        applicationContext.getBean(SimpleAsyncTask.class).execute();
    }

}
