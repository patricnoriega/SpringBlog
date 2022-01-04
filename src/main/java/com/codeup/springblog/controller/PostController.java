package com.codeup.springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String postIndex(Model model) {
        model.addAttribute("posts", postDao.findAll());

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String showPage(@PathVariable long id, Model model){
        Post post = postDao.getById(id);
        model.addAttribute("post", post);

        return "posts/show";
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

