package com.example.mall.mapper;

import com.example.mall.auth.dto.Response.ProductDetailResponseDto;
import com.example.mall.domain.Entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductDetailMapper {

    ProductDetailResponseDto toReseponseDto(Product product);
}
