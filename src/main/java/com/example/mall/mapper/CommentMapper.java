package com.example.mall.mapper;

import com.example.mall.auth.Request.CommentRequsetDto.CommentPostRequestDto;
import com.example.mall.auth.Response.CommentResponseDto.CommentPostResponseDto;
import com.example.mall.domain.Entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CommentMapper {

    Comment toPostEntity(CommentPostRequestDto commentPostRequestDto);

    @Mapping(source = "user.id", target = "id")
    @Mapping(source = "article.id", target = "id")
    CommentPostResponseDto toPostDto(Comment comment);

}
