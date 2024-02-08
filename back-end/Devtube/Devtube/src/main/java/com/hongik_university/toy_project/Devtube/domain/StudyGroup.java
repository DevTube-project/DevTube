package com.hongik_university.toy_project.Devtube.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class StudyGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;
    @Enumerated(EnumType.STRING)
    private BigField bigField;
    @Enumerated(EnumType.STRING)
    private SmallField smallField;
    private String title;
    private Integer capacity;
    private LocalDate date;
    @OneToMany(mappedBy = "studyGroup")
    private List<StudyParticipants> studyParticipants = new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lectureId")
    private Lecture lecture;

}
