package com.hongik_university.toy_project.Devtube.domain.user.entity;

import com.hongik_university.toy_project.Devtube.domain.bookmark.entity.Bookmark;
import com.hongik_university.toy_project.Devtube.domain.review.entity.Review;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 생성자를 통해 값 변경 목적으로 접근하는 메세지들 차단
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private String name;
    private String nickname;
    private int age;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Builder
    private User(
                String username,
                String password,
                String email,
                String name,
                String nickname,
                int age,
                UserRole role,
                SocialType socialType,
                String socialId) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.nickname = nickname;
        this.age = age;
        this.role = role;
        this.socialType = socialType;
        this.socialId = socialId;
    }
    // 로그인한 소셜 타입의 식별자 값 ( 일반 로그인인 경우 null)
    private String socialId;
    @OneToMany(mappedBy = "user")
    private List<Review> reviews = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<Bookmark> bookmarks = new ArrayList<>();

    public void authorizeUser() {
        this.role = UserRole.USER;
    }

    public void passwordEncode(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.password);
    }

}
