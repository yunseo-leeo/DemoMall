package com.example.mall.auth.Response.ArticleResponseDto;

import com.example.mall.domain.ArticleStatus;
import com.example.mall.domain.Entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDetailResponseDto {

    @JsonProperty("ProductId")
    private Long id;

    private String title;

    private String content;

    private ArticleStatus articleStatus;

    private User user;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String image;
}
