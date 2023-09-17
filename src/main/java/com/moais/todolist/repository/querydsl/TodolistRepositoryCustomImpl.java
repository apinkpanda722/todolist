package com.moais.todolist.repository.querydsl;

import com.moais.todolist.dto.TodolistDto;
import com.moais.todolist.entity.QTodolist;
import com.moais.todolist.entity.Todolist;
import com.querydsl.core.types.Projections;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class TodolistRepositoryCustomImpl extends QuerydslRepositorySupport implements TodolistRepositoryCustom {

    public TodolistRepositoryCustomImpl() {super(Todolist.class);}

    QTodolist todolist = QTodolist.todolist;

    @Override
    public TodolistDto findFirst(
            Long userId
    ) {
        return from(todolist)
                .select(Projections.constructor(
                        TodolistDto.class,
                        todolist.todoId,
                        todolist.todo,
                        todolist.todoStatus,
                        todolist.creDttm
                ))
                .where(todolist.userId.eq(userId))
                .orderBy(
                        todolist.creDttm.desc()
                )
                .fetchFirst();
    }

}
