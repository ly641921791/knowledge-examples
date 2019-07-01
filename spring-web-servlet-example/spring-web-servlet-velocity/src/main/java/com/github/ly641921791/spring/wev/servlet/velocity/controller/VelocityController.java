package com.github.ly641921791.spring.wev.servlet.velocity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author wb-ly570538
 */
@Controller
public class VelocityController {

    @RequestMapping(path = "/hello")
    public ModelAndView hello(Model model) {
        ModelAndView modelAndView = new ModelAndView("index");

        String hello = "Hello world";
        model.addAttribute("hello", hello);

        return modelAndView;
    }

}
