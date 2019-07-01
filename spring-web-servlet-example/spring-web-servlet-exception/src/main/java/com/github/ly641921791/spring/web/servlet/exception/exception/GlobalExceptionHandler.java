package com.github.ly641921791.spring.web.servlet.exception.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ly
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public String exceptionHandler(HttpServletRequest request, Throwable throwable) {
        log.error("Handle by global. Message = {}", throwable.getMessage());
        return "Execute error. URL :" + request.getRequestURI();
    }


}
