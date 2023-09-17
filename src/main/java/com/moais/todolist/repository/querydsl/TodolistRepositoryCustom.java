package com.moais.todolist.repository.querydsl;

import com.moais.todolist.dto.TodolistDto;

import java.util.List;

public interface TodolistRepositoryCustom {

    TodolistDto findFirst(
            Long userId
    );
}
