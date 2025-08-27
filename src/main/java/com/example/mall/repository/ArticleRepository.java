package com.example.mall.repository;

import com.example.mall.domain.ArticleStatus;
import com.example.mall.domain.Entity.Article;
import com.example.mall.domain.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>, ArticlerRepositoryCustom {

    List<Article> findByStatus(ArticleStatus status);
    Boolean existsByProductNameAndSeller(String productName, User user);
    Optional<Article> findById(Long id);

    List<Article> findByKeyword(String keyword);




}
