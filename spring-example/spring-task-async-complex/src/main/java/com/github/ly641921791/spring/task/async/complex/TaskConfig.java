package com.github.ly641921791.spring.task.async.complex;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

import java.lang.reflect.Method;

/**
 * @author ly
 */
@Slf4j
@EnableAsync
@Configuration
public class TaskConfig {

    @Bean
    public AsyncConfigurer asyncConfigurer() {
        return new AsyncConfigurer() {
            public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
                return new AsyncUncaughtExceptionHandler() {
                    public void handleUncaughtException(Throwable ex, Method method, Object... params) {
                        log.info("【异步任务】执行异常：method = {} , params = {} , ex = {}", method, params, ex.getClass());
                    }
                };
            }
        };
    }

}
