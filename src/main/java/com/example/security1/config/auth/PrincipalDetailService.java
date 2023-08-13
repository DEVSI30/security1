package com.example.security1.config.auth;

import com.example.security1.model.User;
import com.example.security1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// 시큐리티 설정에서 로그인 프로세스 URL ("/login")
// login 요청이 오면 자동으로 UserDetailService 타입으로 IoC 되어 있는 loadByUsername 함수가 실행 됨
@Service
@RequiredArgsConstructor
public class PrincipalDetailService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User byUserName = userRepository.findByUsername(username);

        if (byUserName != null) {
            return new PrincipalDetail(byUserName);
        }

        return null;
    }
}
