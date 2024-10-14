package com.hongik_university.toy_project.Devtube.domain.user.controller.dto.request;

import com.hongik_university.toy_project.Devtube.domain.user.entity.Gender;

public record UserSignUpRequest(String username,
                            String password,
                            String email,
                            String name,
                            String nickname,
                            int age,
                            Gender gender)
{
}
