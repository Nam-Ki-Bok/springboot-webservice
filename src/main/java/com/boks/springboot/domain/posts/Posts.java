package com.boks.springboot.domain.posts;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter  // 롬복의 Get 생성 어노테이션
@NoArgsConstructor // 롬복의 기본 생성자 자동 추가 어노테이션
@Entity  // DB의 테이블과 매칭 될 클래스임을 나타냄
public class Posts {
    @Id  // 해당 테이블의 PK를 나타냄
    @GeneratedValue (strategy = GenerationType.IDENTITY)  // PK auto_increment
    private Long id;

    @Column (length = 500, nullable = false)
    private String title;

    @Column (columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts (String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}