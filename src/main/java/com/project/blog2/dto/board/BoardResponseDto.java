package com.project.blog2.dto.board;

import com.project.blog2.domain.Board;
import com.project.blog2.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class BoardResponseDto {

    //게시물 목록, 게시물 상세 조회에 필요한 필드를 정의

    private Long id;
    private String title;
    private String content;
//    private int count;
    private User user;
    private LocalDateTime registerTime;

    //Board Entity를 BoardResponseDto에 맞게 변환하는 생성자 생성.
//    public BoardResponseDto(Board entity) {
//        this.id = entity.getId();
//        this.title = entity.getTitle();
//        this.content = entity.getContent();
//        this.count = entity.getCount();
//        this.author = entity.getAuthor();
//        this.registerTime = entity.getCreatedAt();
//    }

}
