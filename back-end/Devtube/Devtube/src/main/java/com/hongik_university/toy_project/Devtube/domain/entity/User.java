package com.hongik_university.toy_project.Devtube.domain.entity;

import com.hongik_university.toy_project.Devtube.domain.enums.Gender;
import com.hongik_university.toy_project.Devtube.domain.enums.SocialType;
import com.hongik_university.toy_project.Devtube.domain.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "USERS")
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 생성자를 통해 값 변경 목적으로 접근하는 메세지들 차단
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String password;
    private String email;
    private String name;
    private String nickname;
    private int age;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Builder
    public User(Long id,
                String userId,
                String password,
                String email,
                String name,
                String nickname,
                int age,
                UserRole role,
                SocialType socialType,
                Gender gender,
                String socialId,
                String refreshToken) {
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.name = name;
        this.nickname = nickname;
        this.age = age;
        this.role = role;
        this.socialType = socialType;
        this.gender = gender;
        this.socialId = socialId;
        this.refreshToken = refreshToken;
    }

    // 로그인한 소셜 타입의 식별자 값 ( 일반 로그인인 경우 null)
    private String socialId;
    // 리프레쉬 토큰
    private String refreshToken;
    @OneToMany(mappedBy = "user")
    private List<Review> reviews = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<Bookmark> bookmarks = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<StudyParticipant> participants = new ArrayList<>();

    // 유저 권한 설정 메서드
    public void authorizeUser() {
        this.role = UserRole.USER;
    }

    public void passwordEncode(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.password);
    }

    public void updateRefreshToken(String updateRefreshToken) {
        this.refreshToken = updateRefreshToken;
    }
}
