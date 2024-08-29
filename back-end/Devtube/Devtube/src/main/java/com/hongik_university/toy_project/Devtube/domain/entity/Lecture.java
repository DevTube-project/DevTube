package com.hongik_university.toy_project.Devtube.domain.entity;
import com.hongik_university.toy_project.Devtube.domain.enums.BigField;
import com.hongik_university.toy_project.Devtube.domain.enums.SmallField;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lectureId;
    String title;
    String url;
    @Enumerated(EnumType.STRING)
    BigField bigField;
    @Enumerated(EnumType.STRING)
    SmallField smallField;
    String channelTitle;
    String imageUrl;
    @OneToMany(mappedBy = "lecture")
    List<Bookmark> bookmarks = new ArrayList<>();
    @OneToMany(mappedBy = "lecture")
    List<Review> reviews = new ArrayList<>();
    @OneToMany(mappedBy = "lecture")
    List<StudyGroup> studyGroups = new ArrayList<>();
    @Builder
    public Lecture(String title,BigField bigField,SmallField smallField,String url,String channelTitle,String imageUrl){
        this.bigField = bigField;
        this.smallField = smallField;
        this.title = title;
        this.channelTitle = channelTitle;
        this.url = url;
        this.imageUrl = imageUrl;
    }

}
