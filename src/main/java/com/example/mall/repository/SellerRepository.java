package com.example.mall.repository;

import com.example.mall.domain.Entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SellerRepository extends JpaRepository<Seller, Long> {
    Optional<Seller> findById(Seller seller);
}
