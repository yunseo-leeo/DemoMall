package com.example.mall.service.ServiceInterface;

import com.example.mall.auth.Request.CommentRequsetDto.CommentPostRequestDto;
import com.example.mall.auth.Response.CommentResponseDto.CommentPostResponseDto;

public interface CommentService {

    CommentPostResponseDto postComment(CommentPostRequestDto commentPostRequestDto);
}
