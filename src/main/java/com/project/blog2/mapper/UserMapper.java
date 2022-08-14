package com.project.blog2.mapper;

import com.project.blog2.domain.User;
import com.project.blog2.dto.user.UserPostDto;
import com.project.blog2.dto.user.UserResponseDto;
import com.project.blog2.dto.user.UserUpdateDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User userPostToUser(UserPostDto userPostDto);
    User userUpdateToUser(UserUpdateDto userUpdateDto);
    UserResponseDto userToUserResponse(User user);
    List<UserResponseDto> usersToUserResponses(List<User> Users);
}
