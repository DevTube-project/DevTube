package com.hongik_university.toy_project.Devtube.service;

import com.hongik_university.toy_project.Devtube.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LectureService {
    private final LectureRepository lectureRepository;
}
