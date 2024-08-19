package com.dongne.its.project.domain;

import com.dongne.its.base.domain.common.BaseEntity;
import com.dongne.its.issue.domain.Issue;
import com.dongne.its.member.domain.Member;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor (access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Project extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 20)
    private Long leaderId;

    @Column
    private boolean isDeleted;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Issue> issueList = new ArrayList<>();

    @OneToMany(mappedBy = "projectMembers", cascade = CascadeType.ALL)
    private List<Member> projectMemberList = new ArrayList<>();
}
