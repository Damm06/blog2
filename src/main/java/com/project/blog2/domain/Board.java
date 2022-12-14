package com.project.blog2.domain;

import com.project.blog2.audit.BaseTimeEntity;
import com.project.blog2.config.auth.PrincipalDetails;
import com.project.blog2.dto.board.BoardRequestDto;
import lombok.*;

import javax.persistence.*;


//@AllArgsConstructor
@Getter
@Setter
@Entity
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    @Lob
    private String content;

    private int count;
//    private String author;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    public Board() {
    }

    @Builder
    public Board(Long id, String title, String content, User user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public Board(String title, String content, User loginUser) {
        this.title = title;
        this.content = content;
        this.user = loginUser;
    }

    @Builder
    public Board(BoardRequestDto boardRequestDto, User user) {
        this.title = boardRequestDto.getTitle();
        this.content = boardRequestDto.getContent();
        this.user = user;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
