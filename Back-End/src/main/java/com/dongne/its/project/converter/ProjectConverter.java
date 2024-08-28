package com.dongne.its.project.converter;

import com.dongne.its.base.converter.ProjectMemberConverter;
import com.dongne.its.issue.converter.IssueConverter;
import com.dongne.its.member.converter.MemberConverter;
import com.dongne.its.project.domain.Project;
import com.dongne.its.project.web.dto.ProjectCreateRequestDto;
import com.dongne.its.project.web.dto.ProjectResponseDto;

import java.util.ArrayList;
import java.util.List;

public class ProjectConverter {

    // Entity 를 ResponseDTO 로 변환
    public static ProjectResponseDto toProjectResponseDto(Project project) {
        return project == null ? null : ProjectResponseDto.builder()
                .id(project.getId())
                .name(project.getName())
                .members(MemberConverter.toMemberResponseDtoList(ProjectMemberConverter.toMembers(project.getProjectMembers())))
                .issues(IssueConverter.toIssueResponseDtoList(project.getIssues()))
                .leaderId(project.getLeaderId())
                .isDeleted(project.getIsDeleted())
                .build();
    }

    // <Project> List 를 <ProjectResponseDto> List 로 변환
    public static List<ProjectResponseDto> toProjectResponseDtoList(List<Project> projects){
        return projects == null ? new ArrayList<>() : projects.stream().map(project -> ProjectResponseDto.builder()
                .id(project.getId())
                .name(project.getName())
                .members(MemberConverter.toMemberResponseDtoList(ProjectMemberConverter.toMembers(project.getProjectMembers())))
                .issues(IssueConverter.toIssueResponseDtoList(project.getIssues()))
                .leaderId(project.getLeaderId())
                .isDeleted(project.getIsDeleted())
                .build()).toList();
    }

    // ResponseDto 를 Entity 로 변환 (필요한가?) <- IDLE : 솔직히 Project 에는 필요하지 않다고 생각하지만 이때까지 create 관련은 모두 Converter 를 써왔기에 일관성 유지를 위해 작성함
    public static Project toProject(ProjectCreateRequestDto request) {
        return Project.builder()
                .name(request.getName())
                .leaderId(request.getMemberIds().get(0))
                .build();
    }
}
