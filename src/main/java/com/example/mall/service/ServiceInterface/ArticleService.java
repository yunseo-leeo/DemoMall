package com.example.mall.service.ServiceInterface;

import com.example.mall.auth.dto.Request.ArticlePostRequestDto;
import com.example.mall.auth.dto.Request.ArticleSearchRequestDto;
import com.example.mall.auth.dto.Request.ArticleUpdateRequestDto;
import com.example.mall.auth.dto.Response.ArticleDetailResponseDto;
import com.example.mall.auth.dto.Response.ArticlePostResponseDto;
import com.example.mall.auth.dto.Response.ArticleSearchResponseDto;
import com.example.mall.auth.dto.Response.ArticleUpdateResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArticleService {

    ArticlePostResponseDto postArticle(ArticlePostRequestDto articlePostRequestDto);

    ArticleDetailResponseDto detailArticle(Long id);

    Page<ArticleSearchResponseDto> searchArticle(ArticleSearchRequestDto articleSearchRequestDto, Pageable pageable);

    ArticleUpdateResponseDto updateArticle(Long id, ArticleUpdateRequestDto articleUpdateRequestDto);
}
