package com.dongne.its.base.converter;

import com.dongne.its.base.domain.mapping.ProjectMember;
import com.dongne.its.member.domain.Member;
import com.dongne.its.project.domain.Project;

import java.util.List;
import java.util.stream.Collectors;

public class ProjectMemberConverter {

    public static List<Member> toMembers(List<ProjectMember> projectMembers) {
        return projectMembers.stream().map(ProjectMember::getMember).collect(Collectors.toList());
    }

    public static List<Project> toProjects(List<ProjectMember> projectMembers) {
        return projectMembers.stream().map(ProjectMember::getProject).collect(Collectors.toList());
    }
}
