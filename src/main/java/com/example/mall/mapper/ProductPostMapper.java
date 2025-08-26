package com.example.mall.mapper;

import com.example.mall.auth.dto.Request.ProductPostRequestDto;
import com.example.mall.auth.dto.Response.ProductPostResponseDto;
import com.example.mall.domain.Entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductPostMapper {

    Product toEntity(ProductPostRequestDto productPostRequestDto);

    ProductPostResponseDto toResponseDto(Product product);

}
