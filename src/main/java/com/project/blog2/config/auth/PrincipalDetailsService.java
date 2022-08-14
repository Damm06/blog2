package com.project.blog2.config.auth;

import com.project.blog2.domain.User;
import com.project.blog2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = userRepository.findByUsername(username);
        System.out.println("username: " + username);
        if(userEntity != null) {
            return new PrincipalDetails(userEntity);
        }
        return null;
    }

    @Transactional
    public void changeEmail(Long userId, String email) {
        Optional<User> user = userRepository.findById(userId);

        User user1 = user.get();
        user1.changeEmail(email);
    }

//    @Transactional
//    public void deleteUser(Long id) {
//        userRepository.deleteById(id);
//    }
}
