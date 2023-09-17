package com.moais.todolist.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TodolistDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 174726374856727L;

    private Long todoId;

    private String todo;

    private String todoStatus;

    private Long userId;

    public TodolistDto(Long todoId,
                      String todo,
                      String todoStatus)
    {
        this.todoId = todoId;
        this.todo = todo;
        this.todoStatus = todoStatus;
    }

}
