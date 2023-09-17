package com.moais.todolist.entity;

import com.moais.todolist.dto.TodolistDto;
import com.moais.todolist.dto.UserDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TODOLIST")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Todolist extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoId;

    @Column(length = 20, nullable = false, name = "todo")
    private String todo;

    @Column(length = 20, nullable = false, name = "todo_status")
    private String todoStatus;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(length = 20, nullable = false, name = "CRE_ID")
    private String creId;

    @Column(length = 20, nullable = false, name = "CRE_IP")
    private String creIp;


    public static TodolistDto toTodolistDto(Todolist todolist) {
        return TodolistDto.builder()
                .todoId(todolist.todoId)
                .todo(todolist.todo)
                .todoStatus(todolist.todoStatus)
                .build();
    }

}
