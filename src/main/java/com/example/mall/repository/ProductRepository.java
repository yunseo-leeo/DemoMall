package com.example.mall.repository;

import com.example.mall.domain.Entity.Product;
import com.example.mall.domain.Entity.Seller;
import com.example.mall.domain.ProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByStatus(ProductStatus status);
    Boolean existsByProductNameAndSeller(String productName, Seller seller);
    Optional<Product> findById(Long id);

}
