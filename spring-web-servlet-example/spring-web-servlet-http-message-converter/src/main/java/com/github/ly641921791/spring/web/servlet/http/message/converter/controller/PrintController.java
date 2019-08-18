package com.github.ly641921791.spring.web.servlet.http.message.converter.controller;

import com.github.ly641921791.spring.web.servlet.http.message.converter.bean.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ly
 */
@RestController
@RequestMapping("/print")
public class PrintController {

    @RequestMapping(value = "/user",
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE
    )
    public User printXml(@RequestBody User user) {
        return user;
    }

    @RequestMapping(value = "/user",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public User printJson(@RequestBody User user) {
        return user;
    }

}
