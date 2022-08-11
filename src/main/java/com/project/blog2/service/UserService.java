package com.project.blog2.service;

import com.project.blog2.domain.User;
import com.project.blog2.exception.BusinessLogicException;
import com.project.blog2.exception.ExceptionCode;
import com.project.blog2.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        verifyExistEmail(user.getEmail());
        User createdUser = userRepository.save(user);
        return createdUser;
    }

    private void verifyExistEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent())
            throw new BusinessLogicException(ExceptionCode.USER_EXISTS);
    }
}
