package com.project.blog2.domain;

import com.project.blog2.audit.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter //IndexController, UserController 테스트 때문에 @Setter 추가함
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(unique = true, nullable = false, length = 50)
    private String username;

    @Column(unique = true, nullable = false, length = 50)
    private String email;

    @Enumerated(EnumType.STRING)
    private RoleType role;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
//    private List<Board> boards = new ArrayList<>();

    @Builder
    public User(Long id, String username, String password, String email, RoleType role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public void changeEmail(String email) {
        this.email = email;
    }

//    public void setboards(Board board) {
//        boards.add(board);
//        if (board.getUser() != this) {
//            board.setUser(this);
//        }
//    }
}
