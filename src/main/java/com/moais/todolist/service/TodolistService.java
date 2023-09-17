package com.moais.todolist.service;

import com.moais.todolist.config.JwtTokenProvider;
import com.moais.todolist.dto.TodolistDto;
import com.moais.todolist.entity.Todolist;
import com.moais.todolist.entity.User;
import com.moais.todolist.repository.TodolistRepository;
import com.moais.todolist.repository.UserRepository;
import com.moais.todolist.repository.querydsl.TodolistRepositoryCustomImpl;
import com.moais.todolist.util.TodoStatus;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class TodolistService {

    private final TodolistRepository todolistRepository;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final TodolistRepositoryCustomImpl todolistRepositoryCustomImpl;

    @Transactional
    public TodolistDto addTodo(HttpServletRequest request, TodolistDto todolistDto) throws Exception {
        User user = getUserByJwt(request);
        Todolist todolist = todolistRepository.save(Todolist.builder()
                        .todo(todolistDto.getTodo())
                        .todoStatus(TodoStatus.WILL.toString())
                        .userId(user.getUserId())
                .build());

        return todolist.toTodolistDto(todolist);
    }

    @Transactional
    public TodolistDto modifyTodo(Long todoId, TodolistDto todolistDto) throws Exception {
        Todolist todolist = todolistRepository.save(Todolist.builder()
                        .todoId(todoId)
                        .todo(todolistDto.getTodo())
                        .todoStatus(todolistDto.getTodoStatus())
                .build());

        return todolist.toTodolistDto(todolist);
    }

    @Transactional
    public void deleteTodo(Long todoId) throws Exception {
        todolistRepository.delete(Todolist.builder()
                .todoId(todoId)
                .build());
    }

    @Transactional
    public List<TodolistDto> getTodolist(HttpServletRequest request) throws Exception {
        User user = getUserByJwt(request);
        List<TodolistDto> todolist = todolistRepository.findAll(Sort.by(Sort.Direction.DESC, "creDttm"))
                .stream()
                .map(todo -> todo.toTodolistDto(todo))
                .collect(Collectors.toList());

        return todolist;

    }

    @Transactional
    public TodolistDto todoFetchOneByRecently(HttpServletRequest request) throws Exception {
        User user = getUserByJwt(request);
        return todolistRepositoryCustomImpl.findFirst(user.getUserId());
    }

    private User getUserByJwt(HttpServletRequest request) {
        String token = jwtTokenProvider.resolveToken(request);
        String loginId = jwtTokenProvider.getUserPk(token.replace("Bearer ", ""));
        User user = userRepository.findByLoginId(loginId);
        return user;
    }
}
