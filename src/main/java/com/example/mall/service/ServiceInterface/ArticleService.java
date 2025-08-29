package com.example.mall.service.ServiceInterface;

import com.example.mall.auth.Request.ArticleRequestDto.ArticlePostRequestDto;
import com.example.mall.auth.Request.ArticleRequestDto.ArticleSearchRequestDto;
import com.example.mall.auth.Request.ArticleRequestDto.ArticleUpdateRequestDto;
import com.example.mall.auth.Response.ArticleResponseDto.ArticleDetailResponseDto;
import com.example.mall.auth.Response.ArticleResponseDto.ArticlePostResponseDto;
import com.example.mall.auth.Response.ArticleResponseDto.ArticleSearchResponseDto;
import com.example.mall.auth.Response.ArticleResponseDto.ArticleUpdateResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArticleService {

    ArticlePostResponseDto postArticle(ArticlePostRequestDto articlePostRequestDto);

    ArticleDetailResponseDto detailArticle(Long id);

    Page<ArticleSearchResponseDto> searchArticle(ArticleSearchRequestDto articleSearchRequestDto, Pageable pageable);

    ArticleUpdateResponseDto updateArticle(Long id, ArticleUpdateRequestDto articleUpdateRequestDto);

    void deleteArticle(Long id, String userEmail);
}
