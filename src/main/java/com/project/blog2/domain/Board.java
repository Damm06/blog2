package com.project.blog2.domain;

import com.project.blog2.audit.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
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

//    private int count;

//    private User user;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

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

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
