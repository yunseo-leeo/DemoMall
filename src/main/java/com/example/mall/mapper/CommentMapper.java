package com.example.mall.mapper;

import com.example.mall.auth.Request.CommentRequsetDto.CommentPostRequestDto;
import com.example.mall.auth.Request.CommentRequsetDto.CommentUpdateRequestDto;
import com.example.mall.auth.Response.CommentResponseDto.CommentPostResponseDto;
import com.example.mall.auth.Response.CommentResponseDto.CommentUpdateResponseDto;
import com.example.mall.domain.Entity.Article;
import com.example.mall.domain.Entity.Comment;
import com.example.mall.domain.Entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CommentMapper {

    Comment toPostEntity(CommentPostRequestDto commentPostRequestDto);

    @Mapping(source = "user.id", target = "id")
    @Mapping(source = "article.id", target = "id")
    CommentPostResponseDto toPostDto(Comment comment);

    default Comment toPostEntity(User user, Article article, CommentPostRequestDto commentPostRequestDto, Comment parent){
        return Comment.builder()
                .article(article)
                .user(user)
                .parent(parent)
                .content(commentPostRequestDto.getContent())
                .build();
    }

    Comment toUpdateFromDto(CommentUpdateRequestDto dto, @MappingTarget Comment comment);
    CommentUpdateResponseDto toUpdateDto(Comment comment);
}
