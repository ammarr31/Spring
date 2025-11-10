package com.example.user_posts.repo;

import com.example.user_posts.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
