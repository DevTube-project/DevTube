package com.hongik_university.toy_project.Devtube.domain.study.entity;

import com.hongik_university.toy_project.Devtube.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class StudyParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long participantId;
    private StudyRole role;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private StudyGroup studyGroup;
}
