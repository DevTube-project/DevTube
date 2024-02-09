package com.hongik_university.toy_project.Devtube.service;

import com.hongik_university.toy_project.Devtube.domain.BigField;
import com.hongik_university.toy_project.Devtube.domain.Gender;
import com.hongik_university.toy_project.Devtube.domain.SmallField;
import com.hongik_university.toy_project.Devtube.domain.Users;
import com.hongik_university.toy_project.Devtube.domain.dto.UsersJoinRequestDto;
import com.hongik_university.toy_project.Devtube.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;
    private final BCryptPasswordEncoder encoder;
    @Transactional
    public void join(UsersJoinRequestDto requestDto){
        //userId 중복 체크
        usersRepository.findByUserId(requestDto.getUserId())
                .ifPresent(users -> {
                    throw new IllegalArgumentException(requestDto.getUserId() + "의 유저 Id는 이미 존재합니다.");
                });
        //nickname 중복 체크
        usersRepository.findByNickname(requestDto.getNickname())
                .ifPresent((users -> {
                    throw new IllegalArgumentException(requestDto.getNickname() + "의 유저 nickname은 이미 존재합니다.");
                }));
        //저장
        Users users = Users.builder().userId(requestDto.getUserId())
                .password(encoder.encode(requestDto.getPassword()))
                .name(requestDto.getName())
                .age(requestDto.getAge())
                .nickname(requestDto.getNickname())
                .gender(Gender.valueOf(requestDto.getGender().toUpperCase()))
                .bigField(BigField.valueOf(requestDto.getBigField().toUpperCase()))
                .smallField(SmallField.valueOf(requestDto.getSmallField().toUpperCase()))
                .build();
        usersRepository.save(users);
    }
}
