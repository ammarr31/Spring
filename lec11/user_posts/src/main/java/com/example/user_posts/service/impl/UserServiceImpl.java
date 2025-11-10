package com.example.user_posts.service.impl;

import com.example.user_posts.dto.UserDto;
import com.example.user_posts.mapper.UserMapper;
import com.example.user_posts.model.User;
import com.example.user_posts.repo.PostRepo;
import com.example.user_posts.repo.UserRepo;
import com.example.user_posts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserMapper mapper;

    @Override
    public User create(UserDto dto) {
        User user = mapper.toEntity(dto);
        return userRepo.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public User update(Long id, UserDto dto) {
        User user = getById(id);
        if (user == null) return null;

        user.setName(dto.getName());
        user.setAge(dto.getAge());
        user.setPassword(dto.getPassword());
        return userRepo.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepo.deleteById(id);
    }
}
