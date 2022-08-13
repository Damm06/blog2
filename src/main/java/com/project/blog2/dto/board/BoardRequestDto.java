package com.project.blog2.dto.board;

import com.project.blog2.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BoardRequestDto {
    private String title;
    private String content;


    private BoardRequestDto() {
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
