package com.springboot.projectboard.service;

import com.springboot.projectboard.constant.SearchType;
import com.springboot.projectboard.domain.Article;
import com.springboot.projectboard.dto.ArticleDto;
import com.springboot.projectboard.dto.ArticleUpdateDto;
import com.springboot.projectboard.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.then;

//@ActiveProfiles("testdb")
@DisplayName("비즈니스 로직 - 게시글")
@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @InjectMocks private ArticleService articleService;
    @Mock private ArticleRepository articleRepository;

    @Test
    @DisplayName("게시글을 검색하면 게시글 리스트를 반환한다.")
    void givenSearchParameters_whenSearchingArticles_thenReturnsArticleList() {
        //Given

        //When
        Page<ArticleDto> articles = articleService.searchArticles(SearchType.TITLE, "search keyword");

        //Then
        assertThat(articles).isNotNull();
    }

    @Test
    @DisplayName("게시글을 조회화면, 게시글을 반환한다.")
    void givenArticleId_whenSearchingArticle_thenReturnsArticle() {
        //Given

        //When
        ArticleDto articles = articleService.searchArticles(1L);

        //Then
        assertThat(articles).isNotNull();
    }

    @Test
    @DisplayName("게시글 정보를 입력하면, 게시글을 생성한다.")
    void givenArticleInfo_whenSavingArticle_thenSavesArticle() {
        //Given
        BDDMockito.given(articleRepository.save(ArgumentMatchers.any(Article.class))).willReturn(null);

        //When
        articleService.saveArticle(ArticleDto.of(LocalDateTime.now(), "cheesecup", "new title", "new content", "#java"));

        //then
        then(articleRepository).should().save(ArgumentMatchers.any(Article.class));
    }

    @Test
    @DisplayName("게시글 정보를 입력하면, 게시글을 수정한다.")
    void givenArticleIdAndModifiedInfo_whenUpdatingArticle_thenUpdatesArticle() {
        //Given
        BDDMockito.given(articleRepository.save(ArgumentMatchers.any(Article.class))).willReturn(null);

        //When
        articleService.updateArticle(1L, ArticleUpdateDto.of( "new title", "new content", "#java"));

        //then
        then(articleRepository).should().save(ArgumentMatchers.any(Article.class));
    }

    @Test
    @DisplayName("게시글 ID를 입력하면, 게시글을 삭제한다.")
    void givenArticleId_whenDeletingArticle_thenDeletesArticle() {
        //Given
        BDDMockito.willDoNothing().given(articleRepository).delete(ArgumentMatchers.any(Article.class));

        //When
        articleService.deleteArticle(1L);

        //then
        then(articleRepository).should().delete(ArgumentMatchers.any(Article.class));
    }

}
