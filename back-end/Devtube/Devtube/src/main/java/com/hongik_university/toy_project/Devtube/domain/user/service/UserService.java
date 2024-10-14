package com.hongik_university.toy_project.Devtube.domain.user.service;

import com.hongik_university.toy_project.Devtube.user.controller.dto.request.UserSignUpDto;
import com.hongik_university.toy_project.Devtube.domain.user.entity.User;
import com.hongik_university.toy_project.Devtube.domain.user.entity.Gender;
import com.hongik_university.toy_project.Devtube.domain.user.entity.UserRole;
import com.hongik_university.toy_project.Devtube.global.error.AppException;
import com.hongik_university.toy_project.Devtube.global.error.ErrorCode;
import com.hongik_university.toy_project.Devtube.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signUp(UserSignUpDto userSignUpDto) {
        if (userRepository.findByUserId(userSignUpDto.getUserId()).isPresent()) {
            throw new AppException(ErrorCode.USERID_DUPLICATED, userSignUpDto.getUserId() + "는 이미 존재하는 아이디 입니다");
        }
        if (userRepository.findByEmail(userSignUpDto.getEmail()).isPresent()) {
            throw new AppException(ErrorCode.USER_EMAIL_DUPLICATED, userSignUpDto.getEmail() + "는 이미 존재하는 이메일 입니다");
        }
        if(userRepository.findByNickname(userSignUpDto.getNickname()).isPresent()){
            throw new AppException(ErrorCode.USER_NICKNAME_DUPLICATED, userSignUpDto.getNickname() + "는 이미 존재하는 닉네임 입니다");
        }
        User user = User.builder()
                .userId(userSignUpDto.getUserId())
                .password(userSignUpDto.getPassword())
                .email(userSignUpDto.getEmail())
                .name(userSignUpDto.getName())
                .nickname(userSignUpDto.getNickname())
                .age(userSignUpDto.getAge())
                .gender(Gender.valueOf(userSignUpDto.getGender().toUpperCase()))
                .role(UserRole.USER)
                .build();
        user.passwordEncode(passwordEncoder);
        userRepository.save(user);
    }
}
