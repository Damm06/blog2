package com.project.blog2.controller;

import com.project.blog2.domain.Board;
import com.project.blog2.domain.User;
import com.project.blog2.dto.SingleResponseDto;
import com.project.blog2.dto.board.BoardUpdateDto;
import com.project.blog2.dto.user.UserUpdateDto;
import com.project.blog2.mapper.UserMapper;
import com.project.blog2.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
@Validated
public class UserController {

    private final UserService userService;

    private final UserMapper mapper;

    public UserController(UserService userService, UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    //회원 가입은 IndexController에서 구현함


    //회원 정보 수정
    @PatchMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity updateUserInfo(@PathVariable long id,
                                         @RequestBody UserUpdateDto userUpdateDto) {
        userUpdateDto.setId(id);
        User user = userService.updateUser(mapper.userUpdateToUser(userUpdateDto));

        return new ResponseEntity<>(new SingleResponseDto<>(mapper.userToUserResponse(user)),
                HttpStatus.OK);
    }


    //회원 목록 조회


    //회원 아이디로 특정 회원 정보 조회


    //회원 탈퇴
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //회원 탈퇴 기능은 DB에서 완전 삭제하기 보다는 Y/N 로 변경해서 조회만 다르게 할 수 있게 로직 변경하기
}
