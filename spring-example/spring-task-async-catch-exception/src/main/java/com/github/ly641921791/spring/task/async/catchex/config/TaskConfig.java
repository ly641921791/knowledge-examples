package com.github.ly641921791.spring.task.async.catchex.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.lang.reflect.Method;

/**
 * @author ly
 **/
@Slf4j
@EnableAsync
@Configuration
public class TaskConfig implements AsyncConfigurer {

    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new AsyncUncaughtExceptionHandler() {
            public void handleUncaughtException(Throwable ex, Method method, Object... params) {
                log.info("【异步任务】执行异常：method = {} , params = {} , ex = {}", method, params, ex.getMessage());
            }
        };
    }

    @Async
    public void asyncTask() {
        System.out.println(Thread.currentThread().getName());
        log.info("【异步任务】开始执行");
        Assert.isTrue(false, "主动触发异常");
        log.info("【异步任务】执行成功");
    }

    @Component
    public static class TaskJob {
        @Async
        public void execute() {
            System.out.println(Thread.currentThread().getName());
            log.info("【异步任务】开始执行");
            Assert.isTrue(false, "主动触发异常");
            log.info("【异步任务】执行成功");
        }
    }

}
