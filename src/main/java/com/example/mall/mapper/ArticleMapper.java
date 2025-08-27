package com.example.mall.mapper;

import com.example.mall.auth.dto.Request.ArticlePostRequestDto;
import com.example.mall.auth.dto.Request.ArticleUpdateRequestDto;
import com.example.mall.auth.dto.Response.ArticleDetailResponseDto;
import com.example.mall.auth.dto.Response.ArticlePostResponseDto;
import com.example.mall.auth.dto.Response.ArticleSearchResponseDto;
import com.example.mall.auth.dto.Response.ArticleUpdateResponseDto;
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

    ArticleUpdateResponseDto toUpdateDto(ArticleUpdateRequestDto dto, @MappingTarget Article article);



}
