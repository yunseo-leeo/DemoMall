package com.example.mall.service.ServiceClass;

import com.example.mall.auth.Request.ArticleRequestDto.ArticlePostRequestDto;
import com.example.mall.auth.Request.ArticleRequestDto.ArticleSearchRequestDto;
import com.example.mall.auth.Request.ArticleRequestDto.ArticleUpdateRequestDto;
import com.example.mall.auth.Response.ArticleResponseDto.ArticleDetailResponseDto;
import com.example.mall.auth.Response.ArticleResponseDto.ArticlePostResponseDto;
import com.example.mall.auth.Response.ArticleResponseDto.ArticleSearchResponseDto;
import com.example.mall.auth.Response.ArticleResponseDto.ArticleUpdateResponseDto;
import com.example.mall.domain.Entity.Article;
import com.example.mall.domain.Entity.User;
import com.example.mall.mapper.*;
import com.example.mall.repository.ArticleRepository;
import com.example.mall.repository.UserRepository;
import com.example.mall.service.ServiceInterface.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.AccessDeniedException;
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
    @Transactional
    public ArticleUpdateResponseDto updateArticle(Long id, ArticleUpdateRequestDto articleUpdateRequestDto){

        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 게시물입니다."));

        articleMapper.toUpdateFromDto(articleUpdateRequestDto, article);

        return articleMapper.toUpdateDto(article);
    }

    @Override
    @Transactional
    public void deleteArticle(Long articleId, String userEmail) {

        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new NoSuchElementException("일치하는 게시물이 존재하지 않습니다."));

        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new NoSuchElementException("회원님의 로그인에 오류가 존재합니다."));

        Boolean isUser = article.getUser() != null && article.getUser().getId().equals(user.getId());

        if (!isUser){throw new AccessDeniedException("삭제 권한이 없습니다.");}

        articleRepository.delete(article);
    }
}
