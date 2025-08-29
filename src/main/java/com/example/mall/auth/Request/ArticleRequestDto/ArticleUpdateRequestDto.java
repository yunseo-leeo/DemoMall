package com.example.mall.auth.Request.ArticleRequestDto;

import com.example.mall.domain.ArticleStatus;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ArticleUpdateRequestDto {
    
    @Size(max = 30, message = "게시물 제목은 30자 이내로 작성해주세요.")
    private String title;

    @Size(max = 1000, message = "게시물 내용은 1000자 이하로 작성해주세요.")
    private String content;

    private String category;

    private ArticleStatus status;

    private String image;




}
