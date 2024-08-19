package com.dongne.its.base.converter;

import com.dongne.its.base.domain.mapping.ProjectMembers;
import com.dongne.its.member.domain.Member;
import com.dongne.its.project.domain.Project;

import java.util.List;
import java.util.stream.Collectors;

public class ProjectMembersConverter {

    public static List<Member> toMembers(List<ProjectMembers> projectMembers) {
        return projectMembers.stream().map(ProjectMembers::getMember).collect(Collectors.toList());
    }

    public static List<Project> toProjects(List<ProjectMembers> projectMembers) {
        return projectMembers.stream().map(ProjectMembers::getProject).collect(Collectors.toList());
    }
}
