package com.hongik_university.toy_project.Devtube.domain;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
    @Enumerated(EnumType.STRING)
    BigField bigField;
    @Enumerated(EnumType.STRING)
    SmallField smallField;
    @Builder
    public Users(String userId,String password,String name,String nickname,Integer age
    ,Gender gender,BigField bigField, SmallField smallField){
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.age = age;
        this.gender = gender;
        this.bigField = bigField;
        this.smallField = smallField;
    }
}
