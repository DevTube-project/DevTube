package com.hongik_university.toy_project.Devtube.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserSignUpDto {
    private String userId;
    private String password;
    private String email;
    private String name;
    private String nickname;
    private int age;
    private String gender;
}
