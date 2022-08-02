package com.project.blog2.domain;

import com.project.blog2.audit.Auditable;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Board extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    @Lob
    private String content;

    private int count;

    private String author;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Builder
    public Board(Long id, String title, String content, int count, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.count = count;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
