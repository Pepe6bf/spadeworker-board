package com.study.spadeworker.domain.article.dto;

import com.study.spadeworker.domain.article.entity.Article;
import com.study.spadeworker.domain.article.entity.ArticleCategory;
import com.study.spadeworker.domain.user.dto.UserAccountDto;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class ArticleDetailDto {
    private Long articleId;

    private String title;

    private String content;

    private int likesCount;

    private int dislikesCount;

    private String articleCategory;
    private LocalDateTime createdAt;
    private UserAccountDto user;
    private List<String> hashtagList;


    private ArticleDetailDto(Long articleId,
                             String title,
                             String content,
                             int likesCount,
                             int dislikesCount,
                             String articleCategory,
                             LocalDateTime createdAt,
                             UserAccountDto userAccountDto,
                             List<String> hashtagList
                             ) {
        this.articleId = articleId;
        this.title = title;
        this.content = content;
        this.likesCount = likesCount;
        this.dislikesCount = dislikesCount;
        this.user = userAccountDto;
        this.articleCategory = articleCategory;
        this.hashtagList = hashtagList;
        this.createdAt = createdAt;
    }

    public static ArticleDetailDto from(Article article, UserAccountDto userAccountDto, List<String> hashtagList) {
        return new ArticleDetailDto(
                article.getId(),
                article.getTitle(),
                article.getContent(),
                article.getLikesCount(),
                article.getDislikesCount(),
                article.getArticleCategory().getTitle(),
                article.getCreatedAt(),
                userAccountDto,
                hashtagList
        );
    }
}
