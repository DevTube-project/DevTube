package com.hongik_university.toy_project.Devtube.service;

import com.hongik_university.toy_project.Devtube.domain.lecture.entity.BigField;
import com.hongik_university.toy_project.Devtube.domain.lecture.entity.Lecture;
import com.hongik_university.toy_project.Devtube.domain.lecture.entity.SmallField;
import com.hongik_university.toy_project.Devtube.domain.lecture.service.LectureService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class LectureServiceTest {
    @Autowired
    private LectureService lectureService;
    @Test
    public void 강의저장(){

        String url = "https://www.googleapis.com/youtube/v3/playlists?part=snippet&id=PLuHgQVnccGMCeAy-2-llhw3nWoQKUvQck&key=AIzaSyBlAPO-tHgidphqbZQoc6vzaH4CdryTsX8";
        Long id = lectureService.save(url, BigField.BASIC, SmallField.JAVA);
        Lecture lecture = lectureService.findById(id);
        String title = "Java 입문 수업 (생활코딩)";
        System.out.println("lecture id = "+lecture.getLectureId());
        System.out.println("lecture title = "+lecture.getTitle());
        System.out.println("lecture ImageUrl = " + lecture.getImageUrl());
        System.out.println("lecture channel = "+lecture.getChannelTitle());
        System.out.println("lecture url = "+lecture.getUrl());
        Assertions.assertEquals(lecture.getTitle(), title);
    }
}