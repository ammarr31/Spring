package com.example.user_posts.mapper;

import com.example.user_posts.dto.UserDto;
import com.example.user_posts.model.User;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserDto dto);

    UserDto toDto(User entity);
}