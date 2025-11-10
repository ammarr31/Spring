package com.example.user_posts.dto;

import com.example.user_posts.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    private Long id;

    private String text;

    private String imagePath;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}