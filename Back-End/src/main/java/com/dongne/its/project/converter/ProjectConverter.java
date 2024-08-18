package com.dongne.its.project.converter;

import com.dongne.its.issue.converter.IssueConverter;
import com.dongne.its.member.converter.MemberConverter;
import com.dongne.its.project.domain.Project;
import com.dongne.its.project.web.dto.ProjectResponseDto;

import java.util.List;

public class ProjectConverter {

    // Entity 를 ResponseDTO 로 변환
    public static ProjectResponseDto toProjectResponseDto(Project project) {
        return ProjectResponseDto.builder()
                .id(project.getId())
                .name(project.getName())
                .members(MemberConverter.toListMemberResponseDto(project.getProjectMemberList()))
                .issues(IssueConverter.toListIssueResponseDto(project.getIssueList()))
                .leaderId(project.getLeaderId())
                .isDeleted(project.isDeleted())
                .build();
    }

    // <Project> List 를 <ProjectResponseDto> List 로 변환
    public static List<ProjectResponseDto> toListProjectResponseDto(List<Project> projects){
        return projects.stream().map(project -> ProjectResponseDto.builder()
                .id(project.getId())
                .name(project.getName())
                .members(MemberConverter.toListMemberResponseDto(project.getProjectMemberList()))
                .issues(IssueConverter.toListIssueResponseDto(project.getIssueList()))
                .leaderId(project.getLeaderId())
                .isDeleted(project.isDeleted())
                .build()).toList();
    }

    // ResponseDto 를 Entity 로 변환 (필요한가?)
    // List <ResponseDto> ->> List <Entity> Converter 가 필요함
    public static Project toProject(ProjectResponseDto request) {
        return Project.builder()
                .id(request.getId())
                .name(request.getName())
                // .projectMemberList(MemberConverter.toListMember(request.getMembers()))
                // .issueList(IssueConverter.toListIssue(request.getIssues()))
                .leaderId(request.getLeaderId())
                .isDeleted(request.isDeleted())
                .build();
    }
}
