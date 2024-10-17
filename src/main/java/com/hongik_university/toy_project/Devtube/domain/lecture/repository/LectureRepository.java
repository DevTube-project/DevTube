package com.hongik_university.toy_project.Devtube.domain.lecture.repository;

import com.hongik_university.toy_project.Devtube.domain.lecture.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture,Long> {
}
