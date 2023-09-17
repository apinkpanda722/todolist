package com.moais.todolist.repository;

import com.moais.todolist.entity.Todolist;
import com.moais.todolist.entity.User;
import com.moais.todolist.repository.querydsl.TodolistRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodolistRepository extends
        JpaRepository<Todolist, Long>,
        TodolistRepositoryCustom {
}
