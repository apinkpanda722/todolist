package com.moais.todolist.entity;

import com.moais.todolist.dto.UserDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "USER")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String nickname;

    @Column(length = 20, nullable = false)
    private String loginId;

    @Column(length = 20, nullable = false)
    private String password;

    public static UserDto toUserDto(User user) {
        return UserDto.builder()
                .id(user.id)
                .nickname(user.nickname)
                .loginId(user.loginId)
                .password(user.password)
                .build();
    }

}
