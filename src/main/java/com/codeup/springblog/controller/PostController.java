package com.codeup.springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
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


    @GetMapping(path = "/posts/create")
    public String postForm(Model viewModel) {
        viewModel.addAttribute("post", new Post());

        return "posts/create";
    }

    @PostMapping(path = "/posts/create")
    public String createPost(@ModelAttribute Post postToBeSaved, long id) {
        User user = userDao.getById(id);
        postToBeSaved.setUser(user);
        Post createdPost = postDao.save(postToBeSaved);

        return "redirect:/posts/" + createdPost;
    }


    @GetMapping("/posts/edit/{id}")
    public String viewEditForm(@PathVariable long id, Model model) {
        Post editPost = postDao.getById(id);

        model.addAttribute("postToEdit", editPost);
        return "posts/edit";
    }

    @PostMapping("/posts/edit/{id}")
        public String saveEditPost(@RequestParam(name="postTitle") String postTitle, @RequestParam(name="postBody") String postBody, @RequestParam(name="postId") long id){


            Post postToEdit = postDao.getById(id);
            postToEdit.setBody(postBody);
            postToEdit.setTitle(postTitle);
            postDao.save(postToEdit);

            return "redirect:/posts";
        }

    @PostMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable long id) {
        postDao.deleteById(id);

        return "redirect:/posts";
    }

}

