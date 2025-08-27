package com.example.mall.service.ServiceClass;

import com.example.mall.auth.dto.Request.ArticlePostRequestDto;
import com.example.mall.auth.dto.Request.ArticleSearchRequestDto;
import com.example.mall.auth.dto.Request.ArticleUpdateRequestDto;
import com.example.mall.auth.dto.Response.ArticleDetailResponseDto;
import com.example.mall.auth.dto.Response.ArticlePostResponseDto;
import com.example.mall.auth.dto.Response.ArticleSearchResponseDto;
import com.example.mall.auth.dto.Response.ArticleUpdateResponseDto;
import com.example.mall.domain.Entity.Article;
import com.example.mall.domain.Entity.User;
import com.example.mall.mapper.*;
import com.example.mall.repository.ArticleRepository;
import com.example.mall.repository.UserRepository;
import com.example.mall.service.ServiceInterface.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;
    private final ArticleMapper articleMapper;

    @Override
    @Transactional
    public ArticlePostResponseDto postArticle(ArticlePostRequestDto articlePostRequestDto) {

        User user = userRepository.findByUser(articlePostRequestDto.getUser())
                .orElseThrow(() -> new NoSuchElementException("작성자를 찾을 수 없습니다."));

        if(articleRepository.existsByProductNameAndSeller(articlePostRequestDto.getTitle(), user)){
            throw new IllegalArgumentException("이미 등록된 게시물입니다.");
        }

        Article article = articleMapper.toPostEntity(articlePostRequestDto);

        article.setUser(user);

        Article savedArticle = articleRepository.save(article);

        return articleMapper.toPostResponseDto(savedArticle);
    }

    @Override
    public ArticleDetailResponseDto detailArticle(Long id) {

        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 게시물입니다."));

        return articleMapper.toDetailReseponseDto(article);
    }

    @Override
    public Page<ArticleSearchResponseDto> searchArticle(ArticleSearchRequestDto articleSearchRequestDto, Pageable pageable) {

        Page<Article> articles = articleRepository.findByKeyword(articleSearchRequestDto, pageable);

        Page<ArticleSearchResponseDto> dtoPage = articles.map(articleMapper::toSearchDto);

        return dtoPage;
    }

    @Override
    public ArticleUpdateResponseDto updateArticle(Long id, ArticleUpdateRequestDto articleUpdateRequestDto){

        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 게시물입니다."));

        return articleMapper.toUpdateDto(articleUpdateRequestDto, article);
    }
}
