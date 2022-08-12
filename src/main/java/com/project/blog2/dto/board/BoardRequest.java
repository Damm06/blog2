package com.project.blog2.dto.board;

import com.project.blog2.domain.Board;
import com.project.blog2.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class BoardRequest {
    private String title;
    private String content;


    private BoardRequest() {
    }

//    public BoardRequest(Board board) {
//        this.user = User.builder().build();
//    }

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .build();
    }

//    public Board toBoardWithLoginUser(User loginUser) {
//        return new Board(
//                title,
//                content,
//                loginUser);
//    }

}
