package com.example.user_posts.controller;

import com.example.user_posts.dto.UserDto;
import com.example.user_posts.model.User;
import com.example.user_posts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping
    public User create(@RequestBody UserDto dto) {
        return userService.create(dto);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody UserDto dto) {
        return userService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @GetMapping("/{id}/posts")
    public List<?> getPosts(@PathVariable Long id) {
        User u = userService.getById(id);
        return u != null ? u.getPosts() : null;
    }
}
