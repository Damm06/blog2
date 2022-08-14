package com.project.blog2.dto.user;

import com.project.blog2.domain.RoleType;
import com.project.blog2.domain.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserResponseDto {

    private Long id;
    private String username;
    private String password;
    private String email;
    private RoleType role;
    private LocalDateTime registerTime;
}
