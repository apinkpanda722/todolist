package com.moais.todolist.controller;

import com.moais.todolist.dto.LoginDto;
import com.moais.todolist.dto.SignUpDto;
import com.moais.todolist.entity.User;
import com.moais.todolist.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("")
@RestController
public class LoginController {

    private final LoginService loginService;
    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestBody LoginDto loginDto) throws Exception {
        return ResponseEntity.ok(loginService.login(loginDto));
    }

    @PostMapping("/signUp")
    public ResponseEntity<User> signUp(
            @RequestBody SignUpDto signUpDto) throws Exception {
        return ResponseEntity.ok(loginService.signUp(signUpDto));
    }

    @GetMapping("/list")
    public String list(
            @RequestBody SignUpDto signUpDto) throws Exception {
        return "1";
    }
}
