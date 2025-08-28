package com.example.mall.repository;

import com.example.mall.auth.Request.ArticleSearchRequestDto;
import com.example.mall.domain.Entity.Article;
import com.example.mall.domain.Entity.QArticle;
import com.example.mall.domain.Entity.QUser;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ArticleRepositoryImpl implements ArticlerRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<Article> findByKeyword(ArticleSearchRequestDto articleSearchRequestDto, Pageable pageable) {

        QArticle article = QArticle.article;
        QUser user = QUser.user;

        String keyword = articleSearchRequestDto.getKeyword();

        BooleanExpression keywordCond = (keyword != null && !keyword.isBlank())
            ? user.userName.containsIgnoreCase(keyword)
                .or(article.title.containsIgnoreCase(keyword))
                .or(article.content.containsIgnoreCase(keyword))
                .or(article.category.containsIgnoreCase(keyword))
            : null;

        List<Article> articles = queryFactory
                .selectFrom(article)
                .join(article.user, user).fetchJoin() // 작성자 정보 fetch
                .where(keywordCond)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        Long totalCount = queryFactory
                .select(article.countDistinct())
                .from(article)
                .join(article.user, user)
                .where(keywordCond)
                .fetchOne();

        return new PageImpl<>(articles, pageable, totalCount != null ? totalCount : 0);
    }
}
