package com.hongik_university.toy_project.Devtube.domain.lecture.controller;

import com.hongik_university.toy_project.Devtube.domain.lecture.service.LectureService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/lecture")
@RequiredArgsConstructor
public class LectureController {
    private final LectureService lectureService;
    @PostConstruct
    public void init(){
        lectureService.create();}
    
}
