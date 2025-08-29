package com.example.mall.auth.Response.ArticleResponseDto;

import com.example.mall.domain.ArticleStatus;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ArticleUpdateResponseDto {

    private String title;

    private String content;

    private String category;

    private ArticleStatus status;

    private String image;
}
