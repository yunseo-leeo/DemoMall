package com.example.mall.service.ServiceInterface;

import com.example.mall.auth.Request.CommentRequsetDto.CommentPostRequestDto;
import com.example.mall.auth.Request.CommentRequsetDto.CommentUpdateRequestDto;
import com.example.mall.auth.Response.CommentResponseDto.CommentPostResponseDto;
import com.example.mall.auth.Response.CommentResponseDto.CommentUpdateResponseDto;

public interface CommentService {

    CommentPostResponseDto postComment(CommentPostRequestDto commentPostRequestDto);

    CommentUpdateResponseDto updateComment(Long id, CommentUpdateRequestDto commentUpdateRequestDto);
}
