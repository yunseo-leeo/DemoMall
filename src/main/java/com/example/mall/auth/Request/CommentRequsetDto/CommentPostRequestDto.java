package com.example.mall.auth.Request.CommentRequsetDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentPostRequestDto {

    @NotNull
    private Long userId;

    @NotNull
    private Long articleId;

    @NotNull
    private Long parentId;

    @NotBlank
    @Size(max = 100, message = "댓글은 100자 이하로 작성해주세요.")
    private String content;


}
