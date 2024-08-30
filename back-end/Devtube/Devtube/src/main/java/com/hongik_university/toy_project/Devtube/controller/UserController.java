package com.hongik_university.toy_project.Devtube.controller;

import com.hongik_university.toy_project.Devtube.domain.dto.UserSignUpDto;
import com.hongik_university.toy_project.Devtube.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<String> signUp(@RequestBody UserSignUpDto userSignUpDto){
        userService.signUp(userSignUpDto);
        return ResponseEntity.ok().body("회원가입에 성공했습니다");
    }

    
}
