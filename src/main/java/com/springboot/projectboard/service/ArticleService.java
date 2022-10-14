package com.springboot.projectboard.service;

import com.springboot.projectboard.constant.SearchType;
import com.springboot.projectboard.dto.ArticleDto;
import com.springboot.projectboard.dto.ArticleUpdateDto;
import com.springboot.projectboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional(readOnly = true)
    public Page<ArticleDto> searchArticles(SearchType searchType, String searchKeyword) {

        return Page.empty();
    }

    public ArticleDto searchArticles(Long id) {

        return null;
    }

    public void saveArticle(ArticleDto dto) {

    }

    public void updateArticle(Long articleId, ArticleUpdateDto dto) {

    }

    public void deleteArticle(Long articleId) {

    }
}
