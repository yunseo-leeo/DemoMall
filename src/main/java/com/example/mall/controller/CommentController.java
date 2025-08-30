package com.example.mall.controller;

import com.example.mall.auth.Request.CommentRequsetDto.CommentPostRequestDto;
import com.example.mall.auth.Request.CommentRequsetDto.CommentUpdateRequestDto;
import com.example.mall.auth.Response.CommentResponseDto.CommentPostResponseDto;
import com.example.mall.auth.Response.CommentResponseDto.CommentUpdateResponseDto;
import com.example.mall.service.ServiceInterface.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/post")
    public ResponseEntity<CommentPostResponseDto> postComment(
            @Valid @RequestBody CommentPostRequestDto commentPostRequestDto) {
        CommentPostResponseDto commentPostResponseDto = commentService.postComment(commentPostRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(commentPostResponseDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CommentUpdateResponseDto> updateComment(
            @PathVariable Long id,
            @Valid @RequestBody CommentUpdateRequestDto commentUpdateRequestDto){
        CommentUpdateResponseDto commentUpdateResponseDto = commentService.updateComment(id, commentUpdateRequestDto);
        return ResponseEntity.ok(commentUpdateResponseDto);
    }
}
