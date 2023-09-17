package com.moais.todolist.dto;

import com.moais.todolist.entity.User;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class TodolistDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 174726374856727L;

    private Long todoId;

    private String todo;

    private String todoStatus;

    private String userId;

}
