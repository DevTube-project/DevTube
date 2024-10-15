package com.hongik_university.toy_project.Devtube.domain.user.repository;

import com.hongik_university.toy_project.Devtube.domain.user.entity.User;

import com.hongik_university.toy_project.Devtube.domain.user.entity.SocialType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

    Optional<User> findByNickname(String nickname);
    /*
     * 소셜 타입과 소셜 식별값으로 회원을 찾는 메서드
     * 정보 제공을 동의한 순간, DB에 저장해야하지만, 아직 추가 정보를 입력 받지 않았으므로
     * 유저 객체는 DB에 있지만, 추가 정보는 빠진 상태
     * 따라서 추가 정보를 입력받아
     */

    Optional<User> findBySocialTypeAndSocialId(SocialType socialType, String socialId);


}
