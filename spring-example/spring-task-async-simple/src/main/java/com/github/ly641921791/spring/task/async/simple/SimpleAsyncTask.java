package com.github.ly641921791.spring.task.async.simple;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author ly
 */
@Slf4j
@Component
public class SimpleAsyncTask {

    @Async
    public void execute() {
        log.info("【任务执行】当前线程：{}", Thread.currentThread().getName());
    }

}
