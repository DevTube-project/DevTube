package com.hongik_university.toy_project.Devtube.repository;

import com.hongik_university.toy_project.Devtube.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,Long> {
    Optional<Users> findByUserId(String userId);

    Optional<Users> findByNickname(String nickname);
}
