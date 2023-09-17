package com.moais.todolist.service;

import com.moais.todolist.config.JwtTokenProvider;
import com.moais.todolist.dto.LoginDto;
import com.moais.todolist.dto.SignUpDto;
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

    private final BCryptPasswordEncoder passwordEncoder;

   @Transactional
    public String login(LoginDto loginDto) throws Exception {
        // ID 체크
        User user = userRepository.findByLoginId(loginDto.getLoginId());

        if (user == null)
            throw new Exception("해당 유저가 존재하지 않습니다.");

        // 로그인 성공시 jwt 토큰 생성
        return jwtTokenProvider.createToken(user.getLoginId());
    }

    @Transactional
    public User signUp(SignUpDto signUpDto) throws Exception {
        return userRepository.save(User.builder()
                        .nickname(signUpDto.getNickname())
                        .loginId(signUpDto.getLoginId())
                        .password(passwordEncoder.encode(signUpDto.getPassword()))
                .build());
    }

    @Transactional
    public void withdrawal(LoginDto loginDto) throws Exception {
        // ID 체크
        User user = userRepository.findByLoginId(loginDto.getLoginId());

        if (user == null)
            throw new Exception("해당 유저가 존재하지 않습니다.");

        userRepository.deleteById(user.getUserId());
    }

}
