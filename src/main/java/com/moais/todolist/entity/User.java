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
    private Long userId;

    @Column(length = 20, nullable = false, name = "nickname")
    private String nickname;

    @Column(length = 20, nullable = false, name = "login_id")
    private String loginId;

    @Column(length = 256, nullable = false, name = "password")
    private String password;

    public static UserDto toUserDto(User user) {
        return UserDto.builder()
                .userId(user.userId)
                .nickname(user.nickname)
                .loginId(user.loginId)
                .password(user.password)
                .build();
    }

}
