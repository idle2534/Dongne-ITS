package com.dongne.its.project.domain;

import com.dongne.its.base.domain.common.BaseEntity;
import com.dongne.its.base.domain.mapping.ProjectMember;
import com.dongne.its.issue.domain.Issue;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
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

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Issue> issues;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<ProjectMember> projectMembers;

    private Boolean isDeleted;
}
