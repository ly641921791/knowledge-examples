package com.github.ly641921791.spring.task.async.catchex;

import com.github.ly641921791.spring.task.async.catchex.config.TaskConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author ly
 **/
@SpringBootApplication
public class AsyncTaskCatchApplication {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        ConfigurableApplicationContext applicationContext = SpringApplication.run(AsyncTaskCatchApplication.class, args);
        applicationContext.getBean(TaskConfig.TaskJob.class).execute();
        applicationContext.getBean(TaskConfig.class).asyncTask();
    }

}
