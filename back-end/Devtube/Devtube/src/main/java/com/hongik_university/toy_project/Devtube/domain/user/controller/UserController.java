package com.hongik_university.toy_project.Devtube.domain.user.controller;

import com.hongik_university.toy_project.Devtube.user.controller.dto.request.UserSignUpDto;
import com.hongik_university.toy_project.Devtube.domain.user.controller.dto.request.UserSignUpRequest;
import com.hongik_university.toy_project.Devtube.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<String> signUp(@RequestBody UserSignUpRequest userSignUpDto) {
        userService.signUp(userSignUpDto);
        return ResponseEntity.ok().body("회원가입에 성공했습니다");
    }

    @GetMapping("/jwt-test")
    public String jwtTest() {
        return "jwtTest 요청 성공";
    }

}
