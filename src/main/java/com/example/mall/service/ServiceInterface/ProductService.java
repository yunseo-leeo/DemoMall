package com.example.mall.service.ServiceInterface;

import com.example.mall.auth.dto.Request.ProductPostRequestDto;
import com.example.mall.auth.dto.Response.ProductDetailResponseDto;
import com.example.mall.auth.dto.Response.ProductPostResponseDto;

public interface ProductService {

    ProductPostResponseDto postProduct(ProductPostRequestDto productPostRequestDto);

    ProductDetailResponseDto detailProduct(Long id);
}
