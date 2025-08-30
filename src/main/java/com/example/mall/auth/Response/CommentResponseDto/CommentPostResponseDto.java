package com.example.mall.auth.Response.CommentResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class CommentPostResponseDto {

    private Long commentId;

    private Long userId;

    private Long articleId;

    private Long parentId;

    private String content;

}
