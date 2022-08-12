package com.project.blog2.repository;

import com.project.blog2.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
    public User findByUsername(String username);

    Optional<User> findById(Long id);
}
