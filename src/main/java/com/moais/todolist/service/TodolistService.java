package com.moais.todolist.service;

import com.moais.todolist.config.JwtTokenProvider;
import com.moais.todolist.dto.TodolistDto;
import com.moais.todolist.entity.Todolist;
import com.moais.todolist.entity.User;
import com.moais.todolist.repository.TodolistRepository;
import com.moais.todolist.repository.UserRepository;
import com.moais.todolist.util.TodoStatus;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class TodolistService {

    private final UserService userService;
    private final TodolistRepository todolistRepository;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public Todolist addTodo(HttpServletRequest request, TodolistDto todolistDto) throws Exception {
        String token = jwtTokenProvider.resolveToken(request);
        String loginId = jwtTokenProvider.getUserPk(token.replace("Bearer ", ""));
        User user = userRepository.findByLoginId(loginId);
        return todolistRepository.save(Todolist.builder()
                        .todo(todolistDto.getTodo())
                        .todoStatus(TodoStatus.WILL.toString())
                        .userId(user.getUserId())
                .build());
    }
}
