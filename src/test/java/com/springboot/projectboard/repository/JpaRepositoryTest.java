package com.springboot.projectboard.repository;

import com.springboot.projectboard.config.JpaConfig;
import com.springboot.projectboard.domain.Article;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("testdb")
// @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // yaml 에서 전역으로 설정 가능 spring.test.database.replace = none
@DisplayName("JPA 연결 테스트")
@Import(JpaConfig.class) // JpaConfig.class 를 인식 시키기 위한 어노테이션
@DataJpaTest // 자동으로 Transactional 이 걸려있다, 내가 설정한 test 용 db 설정을 무시하고 인메모리 h2 db를 사용한다.
class JpaRepositoryTest {

    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;

    public JpaRepositoryTest(@Autowired ArticleRepository articleRepository,
                      @Autowired ArticleCommentRepository articleCommentRepository) {
        this.articleRepository = articleRepository;
        this.articleCommentRepository = articleCommentRepository;
    }

    @Test
    @DisplayName("select 테스트")
    void givenTestData_whenSelecting_thenWorksFine() {
        //given

        //when
        List<Article> articles = articleRepository.findAll();

        //then
        assertThat(articles).isNotNull().hasSize(2);
    }

    @Test
    @DisplayName("insert 테스트")
    void givenTestData_whenInserting_thenWorksFine() {
        //given
        long previousCount = articleRepository.count();
        Article article = Article.of("new title", "new content", "new hashtag");

        //when
        Article savedArticle = articleRepository.save(article);

        //then
        assertThat(articleRepository.count()).isEqualTo(previousCount + 1);
    }

    @Test
    @DisplayName("update 테스트")
    void givenTestData_whenUpdating_thenWorksFine() {
        //given
        Article findArticle = articleRepository.findById(1L).orElseThrow();
        String updateHashtag = "update-hashtag";
        findArticle.setHashtag(updateHashtag);

        //when
        Article savedArticle = articleRepository.saveAndFlush(findArticle);

        //then
        assertThat(savedArticle).hasFieldOrPropertyWithValue("hashtag", updateHashtag);
    }

    @Test
    @DisplayName("delete 테스트")
    void givenTestData_whenDeleting_thenWorksFine() {
        //given
        Article article = articleRepository.findById(1L).orElseThrow();
        long previousArticleCount = articleRepository.count();

        //when
        articleRepository.delete(article);

        //then
        assertThat(articleRepository.count()).isEqualTo(previousArticleCount - 1);
    }
}