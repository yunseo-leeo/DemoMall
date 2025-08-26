package com.example.mall.domain.Entity;

import com.example.mall.domain.ProductStatus;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(
        name= "product",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_seller_product_name",
                columnNames = {"seller_id", "product_name"})
        },
        indexes = {
                @Index(name = "idx_product_seller", columnList = "seller_id"),
                @Index(name = "idx_product_name", columnList = "product_name")
        }
)
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(nullable = false)
    private Integer productPrice;

    @Column(length = 1000)
    private String productDescription;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProductStatus status;

    @Column(nullable = false)
    private String category;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "seller_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_product_seller")
    )
    private Seller seller;

    @CreatedDate
    private LocalDateTime createTime;

    @LastModifiedDate
    private LocalDateTime updateTime;

    @Column(nullable = false)
    private String image;

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

}
