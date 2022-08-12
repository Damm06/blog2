package com.project.blog2.config.auth;

import com.project.blog2.domain.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Data
public class PrincipalDetails implements UserDetails {

    private final User user;

    //이건 OAuth2User 인스턴스 생성을 위해 주입
    //private Map<String, Object> attributes;

    public PrincipalDetails(User user) {
        this.user = user;
    }

    public Long getUserId() {
        return user.getId();
    }
    //이건 OAuth2User 인스턴스 생성을 위해 필요한 생성자
//    public PrincipalDetails(User user, Map<String, Object> attributes) {
//        this.user = user;
//        this.attributes = attributes;
//    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user.getRole().name();
            }
        });
        return collection;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    //이건 OAuth2User 인스턴스 생성을 위해 필요함
//    @Override
//    public Map<String, Object> getAttributes() {
//        return attributes;
//    }
}
