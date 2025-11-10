package com.example.user_posts.controller;

import com.example.user_posts.dto.PostDto;
import com.example.user_posts.model.Post;
import com.example.user_posts.service.PostService;
import com.example.user_posts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public Post create(@RequestBody PostDto dto) {
        return postService.create(dto);
    }

    @GetMapping("/{id}")
    public Post getById(@PathVariable Long id) {
        return postService.getById(id);
    }

    @GetMapping
    public List<Post> getAll() {
        return postService.getAll();
    }

    @PutMapping("/{id}")
    public Post update(@PathVariable Long id, @RequestBody PostDto dto) {
        return postService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        postService.delete(id);
    }

    @GetMapping("/user/{userId}")
    public List<Post> getPostsByUser(@PathVariable Long userId) {
        return postService.getPostsByUser(userId);
    }
}
