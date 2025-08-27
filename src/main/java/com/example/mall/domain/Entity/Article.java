package com.example.mall.domain.Entity;

import com.example.mall.domain.ArticleStatus;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(
        name= "article",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_user_article_name",
                columnNames = {"user_id", "article_name"})
        },
        indexes = {
                @Index(name = "idx_article_user", columnList = "user_id"),
                @Index(name = "idx_article_name", columnList = "article_name")
        }
)
public class Article {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "article_title", nullable = false)
    private String title;


    @Column(length = 1000)
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ArticleStatus status;

    @Column(nullable = false)
    private String category;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "user_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_aritcle_user")
    )
    private User user;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createTime;

    @LastModifiedDate
    private LocalDateTime updateTime;

    @Column(nullable = false)
    private String image;

    public void setUser(User user) {
        this.user = user;
    }

}
