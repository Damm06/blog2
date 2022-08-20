package com.project.blog2.service;

import com.project.blog2.domain.Board;
import com.project.blog2.domain.RoleType;
import com.project.blog2.domain.User;
import com.project.blog2.exception.BusinessLogicException;
import com.project.blog2.exception.ExceptionCode;
import com.project.blog2.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder encoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    //회원가입시 정보 저장
    public User createUser(User user) {
        verifyExistEmail(user.getEmail());
        User createdUser = userRepository.save(user);
        return createdUser;
    }

    //회원 정보 수정
    public User updateUser(User user) {
        User findUser = userRepository.findById(user.getId()).orElseThrow(() ->{
            return new IllegalArgumentException("User does not exist");
        });
        String rawPassword = user.getPassword();
        String encPassword = encoder.encode(rawPassword);

        Optional.ofNullable(user.getEmail())
                .ifPresent(findUser::setEmail);
        Optional.ofNullable(user.getPassword())
                .ifPresent(password -> findUser.setPassword(encPassword));
        return findUser;
    }

    //회원 id로 특정 회원 조회 - admin 기능
    @Transactional(readOnly = true)
    public User findUserById(Long id) {
        return findVerifiedUser(id);
    }

    //회원 목록 조회 - admin 기능
    @Transactional(readOnly = true)
    public Page<User> findUserList(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber()-1, pageable.getPageSize());
        return userRepository.findAll(pageable);
    }

    //회원 정보 삭제
    public void deleteUser(Long id) {
        User findUser = findVerifiedUser(id);
        userRepository.delete(findUser);
    }

    @Transactional(readOnly = true) //회원 정보가 있는지 확인하기
    private User findVerifiedUser(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User findUser =
                optionalUser.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.USER_NOT_FOUND));
        return findUser;
    }

    private void verifyExistEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent())
            throw new BusinessLogicException(ExceptionCode.USER_EXISTS);
    }
}
