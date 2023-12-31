package com.moais.todolist.controller;

import com.moais.todolist.dto.LoginDto;
import com.moais.todolist.dto.SignUpDto;
import com.moais.todolist.entity.User;
import com.moais.todolist.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LoginController {

    private final LoginService loginService;

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

    @DeleteMapping("/withdrawal")
    public void withdrawal(
            @RequestBody LoginDto loginDto) throws Exception {
        loginService.withdrawal(loginDto);
    }
}
