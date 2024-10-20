package com.hongik_university.toy_project.Devtube.domain.user.controller.dto.request;

import com.hongik_university.toy_project.Devtube.domain.user.entity.User;

public record UserSignUpRequest(String username,
                            String password,
                            String email,
                            String name,
                            String nickname,
                            int age)
{
    public  User toEntity(){
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .name(name)
                .nickname(nickname)
                .age(age)
                .build();
    }
}
