package com.springboot.projectboard.service;

import com.springboot.projectboard.domain.ArticleComment;
import com.springboot.projectboard.repository.ArticleCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleCommentService {

    private final ArticleCommentRepository articleCommentRepository;

    public List<ArticleComment> searchArticleComment(Long articleCommentId) {
        return List.of();
    }
}
