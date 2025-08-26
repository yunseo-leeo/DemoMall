package com.example.mall.auth.dto.Request;

import com.example.mall.domain.Entity.Seller;
import com.example.mall.domain.ProductStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductPostRequestDto {

    @NotBlank
    @Size(max = 15, message = "상품 이름은 15자 이내로 작성해주세요.")
    private String productName;

    @NotNull
    @PositiveOrZero
    private Integer productPrice;

    @Size(max = 1000, message = "상품 설명은 1000자 이하로 작성해주세요.")
    private String productDescription;

    @NotNull
    private ProductStatus productStatus;

    @NotNull
    private Seller seller;

    private String image;

}
