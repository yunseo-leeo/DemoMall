package com.example.mall.mapper;

import com.example.mall.auth.Request.ArticleRequestDto.ArticlePostRequestDto;
import com.example.mall.auth.Request.ArticleRequestDto.ArticleUpdateRequestDto;
import com.example.mall.auth.Response.ArticleResponseDto.ArticleDetailResponseDto;
import com.example.mall.auth.Response.ArticleResponseDto.ArticlePostResponseDto;
import com.example.mall.auth.Response.ArticleResponseDto.ArticleSearchResponseDto;
import com.example.mall.auth.Response.ArticleResponseDto.ArticleUpdateResponseDto;
import com.example.mall.domain.Entity.Article;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ArticleMapper {

    ArticleDetailResponseDto toDetailReseponseDto(Article article);

    Article toPostEntity(ArticlePostRequestDto articlePostRequestDto);

    ArticlePostResponseDto toPostResponseDto(Article article);

    ArticleSearchResponseDto toSearchDto(Article article);

    void toUpdateFromDto(ArticleUpdateRequestDto dto, @MappingTarget Article article);

    ArticleUpdateResponseDto toUpdateDto(Article article);



}
