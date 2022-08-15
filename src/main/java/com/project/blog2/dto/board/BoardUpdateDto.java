package com.project.blog2.dto.board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class BoardUpdateDto {
    private Long id;
    private String title;
    private String content;

    @Builder
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void setId(long id) {
        this.id =id;
    }
}
