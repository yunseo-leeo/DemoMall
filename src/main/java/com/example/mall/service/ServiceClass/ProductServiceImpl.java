package com.example.mall.service.ServiceClass;

import com.example.mall.auth.dto.Request.ProductPostRequestDto;
import com.example.mall.auth.dto.Response.ProductDetailResponseDto;
import com.example.mall.auth.dto.Response.ProductPostResponseDto;
import com.example.mall.domain.Entity.Product;
import com.example.mall.domain.Entity.Seller;
import com.example.mall.mapper.ProductDetailMapper;
import com.example.mall.mapper.ProductPostMapper;
import com.example.mall.repository.ProductRepository;
import com.example.mall.repository.SellerRepository;
import com.example.mall.service.ServiceInterface.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductPostMapper productPostMapper;
    private final SellerRepository sellerRepository;
    private final ProductDetailMapper productDetailMapper;

    @Override
    @Transactional
    public ProductPostResponseDto postProduct(ProductPostRequestDto productPostRequestDto) {

        Seller seller = sellerRepository.findById(productPostRequestDto.getSeller())
                .orElseThrow(() -> new NoSuchElementException("판매자를 찾을 수 없습니다."));

        if(productRepository.existsByProductNameAndSeller(productPostRequestDto.getProductName(), seller)){
            throw new IllegalArgumentException("이미 등록된 상품입니다.");
        }

        Product product = productPostMapper.toEntity(productPostRequestDto);

        product.setSeller(seller);

        Product savedProduct = productRepository.save(product);

        return productPostMapper.toResponseDto(savedProduct);
    }

    public ProductDetailResponseDto detailProduct(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 상품입니다."));

        return productDetailMapper.toReseponseDto(product);
    }
}
