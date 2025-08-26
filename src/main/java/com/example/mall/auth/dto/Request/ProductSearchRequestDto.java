package com.example.mall.auth.dto.Request;

import com.example.mall.domain.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductSearchRequestDto {

    private String productName;

    private String category;

    private Integer productPrice;

    private ProductStatus status;



}
