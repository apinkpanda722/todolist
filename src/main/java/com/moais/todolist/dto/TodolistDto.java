package com.moais.todolist.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

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

    private Long userId;

}
