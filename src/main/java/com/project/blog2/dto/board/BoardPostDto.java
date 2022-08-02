package com.project.blog2.dto.board;

import com.project.blog2.domain.Board;
import com.project.blog2.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardPostDto {

    private Long id;
    private String title;
    private String content;
    private String author;

private String userName;

public User getUser() {
    User user = new User();
    user.setName(userName);
    return user;
}

//    public Board toEntity() {
//        return Board.builder()
//                .title(title)
//                .content(content)
//                .author(author)
//                .build();
//    }
}
