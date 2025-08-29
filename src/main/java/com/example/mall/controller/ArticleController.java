package com.example.mall.controller;

import com.example.mall.auth.Request.ArticleRequestDto.ArticlePostRequestDto;
import com.example.mall.auth.Request.ArticleRequestDto.ArticleSearchRequestDto;
import com.example.mall.auth.Request.ArticleRequestDto.ArticleUpdateRequestDto;
import com.example.mall.auth.Response.ArticleResponseDto.ArticleDetailResponseDto;
import com.example.mall.auth.Response.ArticleResponseDto.ArticlePostResponseDto;
import com.example.mall.auth.Response.ArticleResponseDto.ArticleSearchResponseDto;
import com.example.mall.auth.Response.ArticleResponseDto.ArticleUpdateResponseDto;
import com.example.mall.security.CustomUserDetails;
import com.example.mall.service.ServiceInterface.ArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping("/post")
    public ResponseEntity<ArticlePostResponseDto> postArticle(
            @Valid @RequestBody ArticlePostRequestDto articlePostRequestDto){
        ArticlePostResponseDto articlePostResponseDto = articleService.postArticle(articlePostRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(articlePostResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDetailResponseDto> detailArticle(@PathVariable Long id){
        ArticleDetailResponseDto articleDetailResponseDto = articleService.detailArticle(id);
        return ResponseEntity.ok(articleDetailResponseDto);
    }

    @GetMapping
    public Page<ArticleSearchResponseDto> searchArticle(
            @Valid ArticleSearchRequestDto articleSearchRequestDto, Pageable pageable){

        return articleService.searchArticle(articleSearchRequestDto, pageable);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ArticleUpdateResponseDto> updateArticle(
            @PathVariable Long id,
            @Valid @RequestBody ArticleUpdateRequestDto articleUpdateRequestDto){
        ArticleUpdateResponseDto articleUpdateResponseDto = articleService.updateArticle(id, articleUpdateRequestDto);
        return ResponseEntity.ok(articleUpdateResponseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(
            @PathVariable Long id,
            @AuthenticationPrincipal CustomUserDetails user) {

        if(user == null){
            throw new AccessDeniedException("사용자 인증이 필요합니다");
        }

        articleService.deleteArticle(id, user.getUser().getEmail());
        return ResponseEntity.noContent().build();
    }

    
}
