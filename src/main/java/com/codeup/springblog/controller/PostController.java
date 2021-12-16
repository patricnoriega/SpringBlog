package com.codeup.springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @GetMapping(path = "/posts")
    @ResponseBody
    public String posts() {
        return "posts index page";
    }

    @GetMapping(path = "/posts/{id}")
    @ResponseBody
    public String postId(@PathVariable int id) {
        return "view an individual post";
    }


    @GetMapping(path = "/posts/create")
    @ResponseBody
    public String postForm() {
        return "view the form for creating a post";
    }

    @PostMapping(path = "/posts/create")
    @ResponseBody
    public String createPost() {
        return "create a new post";
    }


}

