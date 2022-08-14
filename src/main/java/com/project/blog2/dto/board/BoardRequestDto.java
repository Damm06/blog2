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

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .build();
    }
}
