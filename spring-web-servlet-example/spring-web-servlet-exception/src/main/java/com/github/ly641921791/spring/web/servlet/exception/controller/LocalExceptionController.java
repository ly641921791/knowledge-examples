package com.github.ly641921791.spring.web.servlet.exception.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ly
 */
@Slf4j
@RestController
@RequestMapping("/local/exception")
public class LocalExceptionController {

    @ExceptionHandler
    public String exceptionHandler(HttpServletRequest request, Throwable throwable) {
        log.error("Handle by local. Message = {}", throwable.getMessage());
        return "Execute error. URL :" + request.getRequestURI();
    }

    @RequestMapping("/execute")
    public Object execute() {
        return 1 / 0;
    }

}
