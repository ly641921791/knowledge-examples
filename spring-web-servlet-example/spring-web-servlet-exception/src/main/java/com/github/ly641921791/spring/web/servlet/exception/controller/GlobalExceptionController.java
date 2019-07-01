package com.github.ly641921791.spring.web.servlet.exception.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ly
 */
@RestController
@RequestMapping("/global/exception")
public class GlobalExceptionController {

    @RequestMapping("/execute")
    public Object execute(){
        return 1/0;
    }

}
