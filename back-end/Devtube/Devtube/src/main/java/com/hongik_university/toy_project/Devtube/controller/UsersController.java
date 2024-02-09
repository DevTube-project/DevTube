package com.hongik_university.toy_project.Devtube.controller;

import com.hongik_university.toy_project.Devtube.domain.dto.UsersJoinRequestDto;
import com.hongik_university.toy_project.Devtube.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UsersController {
    private final UsersService usersService;
    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody UsersJoinRequestDto requestDto){
        usersService.join(requestDto);
        return ResponseEntity.ok().body("회원가입이 성공했습니다.");
    }
}
