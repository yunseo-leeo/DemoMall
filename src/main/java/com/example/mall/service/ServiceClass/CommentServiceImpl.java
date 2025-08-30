package com.example.mall.service.ServiceClass;

import com.example.mall.auth.Request.CommentRequsetDto.CommentPostRequestDto;
import com.example.mall.auth.Response.CommentResponseDto.CommentPostResponseDto;
import com.example.mall.domain.Entity.Article;
import com.example.mall.domain.Entity.Comment;
import com.example.mall.domain.Entity.User;
import com.example.mall.mapper.CommentMapper;
import com.example.mall.repository.ArticleRepository;
import com.example.mall.repository.CommentRepository;
import com.example.mall.repository.UserRepository;
import com.example.mall.service.ServiceInterface.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    @Override
    @Transactional
    public CommentPostResponseDto postComment(CommentPostRequestDto commentPostRequestDto) {

        User user = userRepository.findById(commentPostRequestDto.getUserId())
                .orElseThrow(() -> new RuntimeException("회원님의 정보가 존재하지 않습니다."));

        Article article = articleRepository.findById(commentPostRequestDto.getArticleId())
                .orElseThrow(() -> new RuntimeException("게시물이 존재하지 않습니다."));

        Comment parent = null;
        if(commentPostRequestDto.getParentId() != null) {
            parent = commentRepository.findByCommentId(commentPostRequestDto.getParentId())
                    .orElseThrow(() -> new RuntimeException("댓글이 존재하지 않습니다."));
            if(parent != null && parent.getArticle().getId().equals(article.getId())) {
                throw new RuntimeException("<대댓글은 같은 게시물에만 작성할 수 있습니다.");
            }
        }


        Comment comment = Comment.builder()
                .article(article)
                .user(user)
                .parent(parent)
                .content(commentPostRequestDto.getContent())
                .build();

        commentRepository.save(comment);

        return commentMapper.toPostDto(comment);
    }


}
