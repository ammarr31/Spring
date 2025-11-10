package com.example.user_posts.service.impl;

import com.example.user_posts.dto.PostDto;
import com.example.user_posts.mapper.PostMapper;
import com.example.user_posts.model.Post;
import com.example.user_posts.model.User;
import com.example.user_posts.repo.PostRepo;
import com.example.user_posts.repo.UserRepo;
import com.example.user_posts.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PostMapper mapper;

    public PostServiceImpl(PostRepo postRepo, UserRepo userRepo, PostMapper mapper) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
        this.mapper = mapper;
    }

    @Override
    public Post create(PostDto dto) {
        Post post = mapper.toEntity(dto);
        return postRepo.save(post);
    }

    @Override
    public Post getById(Long id) {
        return postRepo.findById(id).orElse(null);
    }

    @Override
    public List<Post> getAll() {
        return postRepo.findAll();
    }

    @Override
    public Post update(Long id, PostDto dto) {
        Post post = getById(id);
        if (post == null) return null;

        post.setText(dto.getText());
        post.setImagePath(dto.getImagePath());
        post.setUser(dto.getUser());

        return postRepo.save(post);
    }

    @Override
    public void delete(Long id) {
        postRepo.deleteById(id);
    }

    @Override
    public List<Post> getPostsByUser(Long userId) {
        User u = userRepo.findById(userId).orElse(null);
        return u != null ? u.getPosts() : null;
    }
}
