package com.hongik_university.toy_project.Devtube.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UsersJoinRequestDto {
    private String userId;
    private String password;
    private String name;
    private String nickname;
    private Integer age;
    private String gender;
    private String bigField;
    private String smallField;
}
