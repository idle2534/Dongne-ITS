package com.dongne.its.member.domain;


import com.dongne.its.base.domain.common.BaseEntity;
import com.dongne.its.base.domain.mapping.ProjectMembers;
import com.dongne.its.issue.domain.Issue;
import com.dongne.its.member.domain.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sign_id")
    private String signId;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<ProjectMembers> projectMembers;

    @OneToMany(mappedBy = "reporter", cascade = CascadeType.ALL)
    private List<Issue> reportIssues;

    @OneToMany(mappedBy = "fixer", cascade = CascadeType.ALL)
    private List<Issue> fixIssues;

    @OneToMany(mappedBy = "assignee", cascade = CascadeType.ALL)
    private List<Issue> assignIssues;

    private String name;

    private boolean isDeleted;
}
