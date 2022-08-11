package com.project.blog2.exception;

import lombok.Getter;

public enum ExceptionCode {

    USER_NOT_FOUND(404, "User not found"),
    USER_EXISTS(409, "User exists"),
    BOARD_NOT_FOUND(404, "Board not found"),
    AUTHOR_NOT_EXISTS(409, "Author not Exists"),
    CANNOT_CHANGE_BOARD(403, "Board can not change"),
    NOT_IMPLEMENTATION(501, "Not Implementation"),
    INVALID_MEMBER_STATUS(400, "Invalid member status");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message) {
        this.status = code;
        this.message = message;
    }
}
