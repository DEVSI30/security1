package com.example.security1.config.auth;

// 시큐리티가 /login 낚아채서 로그인 진행시킨다.
// 로그이늘 진행이 완료가 되면 시큐리티 session을 만들어줍니다.
// 오브젝트 => Authentication 객체만 세션에 저장할 수 있음
// Authenticatino 안에 User 정보가 있어야 됨
// User 오브젝트의타입 => UserDetails 타입 객체

import com.example.security1.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;

// 시큐리티가 가지고 있는
public class PrincipalDetail implements UserDetails {
    private User user;

    public PrincipalDetail(User user) {
        this.user = user;
    }

    // 해당 유저의 권한을 리턴하는 곳
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add((GrantedAuthority) () -> user.getRole());
        return collect;
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
}
