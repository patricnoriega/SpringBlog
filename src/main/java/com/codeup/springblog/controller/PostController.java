package com.codeup.springblog.controller;

import com.codeup.springblog.Models.Post;
import com.codeup.springblog.Repository.PostRepository;
import com.codeup.springblog.Repository.UserRepository;
import com.codeup.springblog.emailService.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailService;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

    @GetMapping("/posts")
    public String postIndex(Model model) {
        model.addAttribute("posts", postDao.findAll());

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String showPage(@PathVariable long id, Model model) {
        Post post = postDao.getById(id);
        model.addAttribute("post", post);

        return "posts/show";
    }


    @GetMapping("/posts/create")
    public String postForm(Model model) {
        model.addAttribute("post", new Post());

        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {

        post.setUser(userDao.getById(1L));
        String emailSubject = post.getUser().getUsername() + ", Your post has been created";

        String emailBody = "Congratulations - Your latest blog post is up and ready to view on you blogging website. Your post read:" + post.getBody();

        postDao.save(post);
        emailService.prepareAndSend(post, emailSubject, emailBody);


        return "redirect:/posts";
    }


    @GetMapping("/posts/edit/{id}")
    public String editForm(@PathVariable long id, Model model) {
        model.addAttribute("postToEdit", postDao.getById(1L));

        return "posts/edit";
    }

    @PostMapping("/posts/edit/{id}")
    public String saveEditPost(@ModelAttribute Post postToEdit) {

        postToEdit.setUser(userDao.getById(1L));
        postDao.save(postToEdit);

        return "redirect:/posts";
    }

    @PostMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable long id) {
        postDao.deleteById(id);

        return "redirect:/posts";
    }

}

