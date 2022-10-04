package com.springboot.projectboard.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "hashtag"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy"),
})
@EntityListeners(AuditingEntityListener.class)
public class Article {

    /* MySQl Auto Increment = IDENTITY 타입*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false)
    private String title; // 제목

    @Setter
    @Column(nullable = false, length = 10000)
    private String content; // 본문

    @Setter
    private String hashtag; // 해시태그

    @OrderBy("id")
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    @ToString.Exclude
    private final Set<ArticleComment> articleComments = new LinkedHashSet<>();

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt; // 생성일시

    @CreatedBy
    @Column(nullable = false, length = 100)
    private String createdBy; // 생성자

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime modifiedAt; // 수정 일시

    @LastModifiedBy
    @Column(nullable = false, length = 100)
    private String modifiedBy; // 수정자

    protected Article() {}

    private Article(String title, String content, String hashtag) {
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
    }

    /* 생성자를 사용하기 위한 메소드*/
    public static Article of(String title, String content, String hashtag) {
        return new Article(title, content, hashtag);
    }

    /*
    * 객체의 모든 필드를 비교 하지 않고, PK인 id 필드만 가지고 equals() 검증
    * 비교하려는 객체가 아직 영속화 되지 않았다면 비교되는 객체와
    * 필드 값이 모두 같더라도 insert 상태가 아니므로 not equals 즉, false 를 반환한다.
    * */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article article)) return false; // Java 11 버전에서는 사용x
//        Article article = (Article) o; // Java 11 버전 사용시 코드
        return id != null && id.equals(article.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
