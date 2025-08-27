package com.example.mall.repository;

import com.example.mall.auth.dto.Request.ArticleSearchRequestDto;
import com.example.mall.domain.Entity.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

public interface ArticlerRepositoryCustom {
    Page<Article> findByKeyword(ArticleSearchRequestDto articleSearchRequestDto, Pageable pageable);
}
