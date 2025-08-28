package com.example.mall.service.ServiceInterface;

import com.example.mall.auth.Request.ArticlePostRequestDto;
import com.example.mall.auth.Request.ArticleSearchRequestDto;
import com.example.mall.auth.Request.ArticleUpdateRequestDto;
import com.example.mall.auth.Response.ArticleDetailResponseDto;
import com.example.mall.auth.Response.ArticlePostResponseDto;
import com.example.mall.auth.Response.ArticleSearchResponseDto;
import com.example.mall.auth.Response.ArticleUpdateResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArticleService {

    ArticlePostResponseDto postArticle(ArticlePostRequestDto articlePostRequestDto);

    ArticleDetailResponseDto detailArticle(Long id);

    Page<ArticleSearchResponseDto> searchArticle(ArticleSearchRequestDto articleSearchRequestDto, Pageable pageable);

    ArticleUpdateResponseDto updateArticle(Long id, ArticleUpdateRequestDto articleUpdateRequestDto);
}
