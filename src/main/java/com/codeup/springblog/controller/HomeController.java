package com.codeup.springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping(path = "/")
    @ResponseBody
    public String landingPage() {
        return "This is the landing page!";
    }

    @GetMapping(path = "/home")
    public String welcome() {
        return "home";
    }

}
