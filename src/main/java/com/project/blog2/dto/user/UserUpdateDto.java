package com.project.blog2.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserUpdateDto {
    private String email;
    private String password;

    @Builder
    public UserUpdateDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
