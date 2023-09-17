package com.moais.todolist.controller;

import com.moais.todolist.dto.TodolistDto;
import com.moais.todolist.entity.Todolist;
import com.moais.todolist.entity.User;
import com.moais.todolist.service.TodolistService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
public class TodolistController {

    private final TodolistService todolistService;

    @PostMapping("/todolist")
    public ResponseEntity<TodolistDto> todolist(
            HttpServletRequest request,
            @RequestBody TodolistDto todolistDto,
            @AuthenticationPrincipal User user) throws Exception {
        return ResponseEntity.ok(todolistService.addTodo(request, todolistDto));
    }

    @PutMapping("/todolist/{todoId}")
    public ResponseEntity<TodolistDto> todoModify(
            @PathVariable("todoId") Long todoId,
            @RequestBody TodolistDto todolistDto,
            @AuthenticationPrincipal User user) throws Exception {
        return ResponseEntity.ok(todolistService.modifyTodo(todoId, todolistDto));
    }

    @DeleteMapping("/todolist/{todoId}")
    public void todoDelete(
            @PathVariable("todoId") Long todoId,
            @AuthenticationPrincipal User user) throws Exception {
        todolistService.deleteTodo(todoId);
    }

    @GetMapping("/todolist")
    public ResponseEntity<List<TodolistDto>> getTodolist(
            HttpServletRequest request,
            @AuthenticationPrincipal User user) throws Exception {
        return ResponseEntity.ok(todolistService.getTodolist(request));
    }

    @GetMapping("/todolist/todo/latest")
    public ResponseEntity<TodolistDto> todoFetchOneByRecently(
            HttpServletRequest request,
            @AuthenticationPrincipal User user) throws Exception {
        return ResponseEntity.ok(todolistService.todoFetchOneByRecently(request));
    }
}
