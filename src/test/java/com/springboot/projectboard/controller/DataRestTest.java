package com.springboot.projectboard.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

@Disabled("Spring Data REST 통합 테스트는 불필요하므로 제외시킴")
@DisplayName("Data REST - API 테스트")
@Transactional // 롤백을 시키기 위한 트랜잭션 어노테이션
@AutoConfigureMockMvc
@SpringBootTest
public class DataRestTest {

    private final MockMvc mockMvc;

    public DataRestTest(@Autowired MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    @DisplayName("[api] 게시글 조회")
    void givenNothing_whenRequestingArticles_thenReturnsArticlesJsonResponse() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/articles"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.valueOf("application/hal+json")));

    }

    @Test
    @DisplayName("[api] 게시글 단건 조회")
    void givenNothing_whenRequestingArticles_thenReturnsArticleJsonResponse() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/articles/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.valueOf("application/hal+json")));

    }

    @Test
    @DisplayName("[api] 게시글 -> 댓글 리스트 조회")
    void givenNothing_whenRequestingArticleCommentsFromArticle_thenReturnsArticleCommentsJsonResponse() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/articleComments"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @Test
    @DisplayName("[api] 게시글 -> 댓글 단건 조회")
    void givenNothing_whenRequestingArticleCommentsFromArticle_thenReturnsArticleCommentJsonResponse() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/api/articleComments/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @Test
    @DisplayName("[api] 회원 관련 API 는 일체 제공하지 않는다.")
    void givenNothing_whenRequestingUserAccounts_thenThrowsException() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/userAccounts"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
        mockMvc.perform(MockMvcRequestBuilders.post("/api/userAccounts"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
        mockMvc.perform(MockMvcRequestBuilders.put("/api/userAccounts"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
        mockMvc.perform(MockMvcRequestBuilders.patch("/api/userAccounts"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/userAccounts"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
        mockMvc.perform(MockMvcRequestBuilders.head("/api/userAccounts"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
