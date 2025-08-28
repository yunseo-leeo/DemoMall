package com.example.mall.controller;

import com.example.mall.auth.Request.ArticlePostRequestDto;
import com.example.mall.auth.Request.ArticleSearchRequestDto;
import com.example.mall.auth.Request.ArticleUpdateRequestDto;
import com.example.mall.auth.Response.ArticleDetailResponseDto;
import com.example.mall.auth.Response.ArticlePostResponseDto;
import com.example.mall.auth.Response.ArticleSearchResponseDto;
import com.example.mall.auth.Response.ArticleUpdateResponseDto;
import com.example.mall.service.ServiceInterface.ArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    
}
