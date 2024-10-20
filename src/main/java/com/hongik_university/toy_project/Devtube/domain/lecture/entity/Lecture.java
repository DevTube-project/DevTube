package com.hongik_university.toy_project.Devtube.domain.lecture.entity;
import com.hongik_university.toy_project.Devtube.domain.bookmark.entity.Bookmark;
import com.hongik_university.toy_project.Devtube.domain.review.entity.Review;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String title;
    String url;
    String channelTitle;
    @OneToMany(mappedBy = "lecture", cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<Bookmark> bookmarks = new ArrayList<>();
    @OneToMany(mappedBy = "lecture", cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<Review> reviews = new ArrayList<>();

    @Builder
    private Lecture(String title, String url, String channelTitle) {
        this.title = title;
        this.channelTitle = channelTitle;
        this.url = url;
    }

}
