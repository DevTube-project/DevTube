package com.hongik_university.toy_project.Devtube.domain.user.service;

import com.hongik_university.toy_project.Devtube.domain.user.controller.dto.request.UserSignUpRequest;
import com.hongik_university.toy_project.Devtube.domain.user.entity.User;
import com.hongik_university.toy_project.Devtube.domain.user.entity.UserRole;
import com.hongik_university.toy_project.Devtube.domain.user.repository.UserRepository;
import com.hongik_university.toy_project.Devtube.global.error.AppException;
import com.hongik_university.toy_project.Devtube.global.error.ErrorCode;
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

    public void signUp(UserSignUpRequest userSignUpRequest) {
        if (userRepository.findByUsername(userSignUpRequest.username()).isPresent()) {
            throw new AppException(ErrorCode.USERID_DUPLICATED, userSignUpRequest.username() + "는 이미 존재하는 아이디 입니다");
        }
        if (userRepository.findByEmail(userSignUpRequest.email()).isPresent()) {
            throw new AppException(ErrorCode.USER_EMAIL_DUPLICATED, userSignUpRequest.email() + "는 이미 존재하는 이메일 입니다");
        }
        if(userRepository.findByNickname(userSignUpRequest.nickname()).isPresent()){
            throw new AppException(ErrorCode.USER_NICKNAME_DUPLICATED, userSignUpRequest.name() + "는 이미 존재하는 닉네임 입니다");
        }
        User user = userSignUpRequest.toEntity();
        user.passwordEncode(passwordEncoder);
        user.authorizeUser();
        userRepository.save(user);
    }
}
