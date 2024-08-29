package com.hongik_university.toy_project.Devtube.domain;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String password;
    private String name;
    private String nickname;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @OneToMany(mappedBy = "users")
    private List<Review> reviews = new ArrayList<>();
    @OneToMany(mappedBy = "users")
    private List<Bookmark> bookmarks = new ArrayList<>();
    @OneToMany(mappedBy = "users")
    private List<StudyParticipants> participants = new ArrayList<>();

    @Builder
    public Users(String userId, String password, String name, String nickname, Integer age
    , Gender gender){
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.age = age;
        this.gender = gender;
    }
}
