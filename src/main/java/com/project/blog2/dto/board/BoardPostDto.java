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


    private String title;
    private String content;
    private String author;


    //이 부분은 User 서비스랑 컨트롤러 구현하고 다시 수정해서 추가 예정
//private String userName;
//
//public User getUser() {
//    User user = new User();
//    user.setName(userName);
//    return user;
//}

//    public Board toEntity() {
//        return Board.builder()
//                .title(title)
//                .content(content)
//                .author(author)
//                .build();
//    }
}
