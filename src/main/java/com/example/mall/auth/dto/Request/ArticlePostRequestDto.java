package com.example.mall.auth.dto.Request;

import com.example.mall.domain.ArticleStatus;
import com.example.mall.domain.Entity.Seller;
import com.example.mall.domain.Entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ArticlePostRequestDto {

    @NotBlank
    @Size(max = 30, message = "게시물 제목은 30자 이내로 작성해주세요.")
    private String title;


    @Size(max = 1000, message = "게시물 내용은 1000자 이하로 작성해주세요.")
    private String content;

    @NotNull
    private ArticleStatus articleStatus;

    @NotNull
    private User user;

    private String image;

}
