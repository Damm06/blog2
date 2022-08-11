package com.project.blog2.dto.board;

import com.project.blog2.domain.Board;
import com.project.blog2.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardRequest {
    private String title;
    private String content;

    private BoardRequest() {
    }

    public Board toBoardWithLoginUser(User loginUser) {
        return new Board(
                title,
                content,
                loginUser);
    }

}
