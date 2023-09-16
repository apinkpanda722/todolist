package com.moais.todolist.dto;

import com.moais.todolist.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class LoginDto {

    private String loginId;

    private String password;
}
