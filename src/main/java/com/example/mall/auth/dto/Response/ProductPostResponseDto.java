package com.example.mall.auth.dto.Response;

import com.example.mall.domain.Entity.Seller;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductPostResponseDto {

    @JsonProperty("productId")
    private Long id;

    private Integer productPrice;

    private String productName;

    private String productDescription;

    private Seller seller;

    private LocalDateTime createTime;

    private String image;
}
