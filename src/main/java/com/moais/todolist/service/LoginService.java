package com.moais.todolist.service;

import com.moais.todolist.config.JwtTokenProvider;
import com.moais.todolist.dto.LoginDto;
import com.moais.todolist.entity.User;
import com.moais.todolist.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService {

    private final UserRepository userRepository;

    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public String login(LoginDto loginDto) throws Exception {
        // ID 체크
        User user = userRepository.findByLoginId(loginDto.getLoginId());

        // 로그인 성공시 jwt 토큰 생성
        return jwtTokenProvider.createToken(user.getLoginId());
    }

}
