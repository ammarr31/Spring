package com.example.user_posts.service;

import com.example.user_posts.dto.UserDto;
import com.example.user_posts.model.User;

import java.util.List;

public interface UserService {

    User create(UserDto dto);

    User getById(Long id);

    List<User> getAll();

    User update(Long id, UserDto dto);

    void delete(Long id);
}
