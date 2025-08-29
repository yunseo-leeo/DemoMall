package com.example.mall.auth.Response.ArticleResponseDto;

import com.example.mall.domain.ArticleStatus;
import com.example.mall.domain.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleSearchResponseDto {

    private String articleName;

    private String category;

    private User user;

    private ArticleStatus status;

    private String content;

    private LocalDateTime createTime;

    private String image;
}
