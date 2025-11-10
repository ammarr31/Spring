package com.example.user_posts.service;

import com.example.user_posts.dto.PostDto;
import com.example.user_posts.model.Post;

import java.util.List;

public interface PostService {

    Post create(PostDto dto);

    Post getById(Long id);

    List<Post> getAll();

    Post update(Long id, PostDto dto);

    void delete(Long id);

    List<Post> getPostsByUser(Long userId);
}
