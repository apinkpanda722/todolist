package com.moais.todolist.controller;

import com.moais.todolist.dto.LoginDto;
import com.moais.todolist.dto.SignUpDto;
import com.moais.todolist.dto.TodolistDto;
import com.moais.todolist.entity.Todolist;
import com.moais.todolist.entity.User;
import com.moais.todolist.service.LoginService;
import com.moais.todolist.service.TodolistService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("")
@RestController
public class LoginController {

    private final LoginService loginService;

    private final TodolistService todolistService;

    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestBody LoginDto loginDto) throws Exception {
        return ResponseEntity.ok(loginService.login(loginDto));
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signUp(
            @RequestBody SignUpDto signUpDto) throws Exception {
        return ResponseEntity.ok(loginService.signUp(signUpDto));
    }

    @PostMapping("/withdrawal")
    public void withdrawal(
            @RequestBody LoginDto loginDto) throws Exception {
        loginService.withdrawal(loginDto);
    }

    @PostMapping("/todolist")
    public ResponseEntity<Todolist> todolist(
            HttpServletRequest request,
            @RequestBody TodolistDto todolistDto,
            @AuthenticationPrincipal User user) throws Exception {
        return ResponseEntity.ok(todolistService.addTodo(request, todolistDto));
    }
}
