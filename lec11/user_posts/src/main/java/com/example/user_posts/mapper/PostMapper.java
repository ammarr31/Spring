package com.example.user_posts.mapper;

import com.example.user_posts.dto.PostDto;
import com.example.user_posts.model.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface PostMapper {

    Post toEntity(PostDto dto);

    PostDto toDto(Post entity);
}