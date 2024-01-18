package com.hongik_university.toy_project.Devtube.repository;

import com.hongik_university.toy_project.Devtube.domain.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture,Long> {
}
