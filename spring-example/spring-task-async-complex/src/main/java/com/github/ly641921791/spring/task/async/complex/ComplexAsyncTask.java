package com.github.ly641921791.spring.task.async.complex;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author ly
 */
@Slf4j
@Component
public class ComplexAsyncTask {

    @Async
    public void executeNormal() {
        log.info("【异步任务】executeNormal执行成功");
    }

    @Async
    public void executeException() {
        int i = 1 / 0;
        log.info("【异步任务】executeException执行成功");
    }

}
