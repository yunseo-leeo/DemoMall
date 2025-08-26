package com.example.mall.controller;

import com.example.mall.auth.dto.Request.ProductPostRequestDto;
import com.example.mall.auth.dto.Response.ProductDetailResponseDto;
import com.example.mall.auth.dto.Response.ProductPostResponseDto;
import com.example.mall.service.ServiceInterface.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/post")
    public ResponseEntity<ProductPostResponseDto> postProduct(
            @Valid @RequestBody ProductPostRequestDto productPostRequestDto){
        ProductPostResponseDto productPostResponseDto = productService.postProduct(productPostRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productPostResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDetailResponseDto> detailProduct(@PathVariable Long id){
        ProductDetailResponseDto productDetailResponseDto = productService.detailProduct(id);
        return ResponseEntity.ok(productDetailResponseDto);
    }
    
}
