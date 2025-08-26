package com.example.mall.auth.dto.Response;

import com.example.mall.domain.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductSearchResponseDto {

    private String productName;

    private String category;

    private Integer productPrice;

    private ProductStatus status;
}
