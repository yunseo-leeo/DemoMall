package com.example.mall.repository;

import com.example.mall.auth.Request.ArticleSearchRequestDto;
import com.example.mall.domain.Entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArticlerRepositoryCustom {
    Page<Article> findByKeyword(ArticleSearchRequestDto articleSearchRequestDto, Pageable pageable);
}
