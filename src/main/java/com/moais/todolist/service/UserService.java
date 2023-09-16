package com.moais.todolist.service;

import com.moais.todolist.dto.UserDto;
import com.moais.todolist.entity.User;
import com.moais.todolist.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDto loadUserByUsername(String loginId) {
        User user = userRepository.findByLoginId(loginId);
        return User.toUserDto(user);
    }

}
