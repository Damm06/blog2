package com.project.blog2.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public enum RoleType {
    ROLE_ADMIN("관리자"),
    ROLE_USER("사용자");

    private String value;
}
