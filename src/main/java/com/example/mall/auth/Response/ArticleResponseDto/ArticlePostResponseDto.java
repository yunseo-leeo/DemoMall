package com.example.mall.auth.Response.ArticleResponseDto;

import com.example.mall.domain.Entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
public class ArticlePostResponseDto {

    @JsonProperty("ArticleId")
    private Long id;

    private String title;

    private String content;

    private User user;

    private LocalDateTime createTime;

    private String image;
}
