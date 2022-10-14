package com.springboot.projectboard.service;

import com.springboot.projectboard.domain.Article;
import com.springboot.projectboard.domain.ArticleComment;
import com.springboot.projectboard.repository.ArticleCommentRepository;
import com.springboot.projectboard.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.then;

@DisplayName("비즈니스 로직 - 댓글")
@ExtendWith(MockitoExtension.class)
class ArticleCommentServiceTest {

    @InjectMocks private ArticleCommentService articleCommentService;
    @Mock private ArticleCommentRepository articleCommentRepository;
    @Mock private ArticleRepository articleRepository;

    @Test
    @DisplayName("게시글 ID로 조회하면, 해당하는 댓글 리스트를 반환한다.")
    void givenArticleId_whenSearchingComments_thenReturnsArticleComments() {
        //Given
        Long articleId = 1L;
        BDDMockito.given(articleRepository.findById(articleId))
                .willReturn(Optional.of(Article.of("title", "content","#java")));

        //When
        List<ArticleComment> articleComments = articleCommentService.searchArticleComment(articleId);

        //Then
        assertThat(articleComments).isNotNull();
        then(articleRepository).should().findById(articleId);
    }

}