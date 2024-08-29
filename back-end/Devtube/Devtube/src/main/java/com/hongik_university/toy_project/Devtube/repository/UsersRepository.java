package com.hongik_university.toy_project.Devtube.repository;

import com.hongik_university.toy_project.Devtube.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User,Long> {
    Optional<User> findByUserId(String userId);

    Optional<User> findByNickname(String nickname);
}
