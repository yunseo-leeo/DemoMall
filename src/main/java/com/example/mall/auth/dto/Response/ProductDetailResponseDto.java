package com.example.mall.auth.dto.Response;

import com.example.mall.domain.Entity.Seller;
import com.example.mall.domain.ProductStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailResponseDto {

    @JsonProperty("ProductId")
    private Long id;

    private String productName;

    private String productDescription;

    private Integer productPrice;

    private ProductStatus productStatus;

    private Seller seller;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String image;
}
