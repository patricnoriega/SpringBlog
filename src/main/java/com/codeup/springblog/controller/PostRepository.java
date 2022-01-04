package com.codeup.springblog.controller;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
//    Post findById(long id);
//    Post findPostsById(long id);
//    Post findPostById(long id);
//    Post getPostById(long id);
}
