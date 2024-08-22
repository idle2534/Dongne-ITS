package com.dongne.its.project.service;

import com.dongne.its.base.Repository.ProjectMemberRepository;
import com.dongne.its.base.domain.mapping.ProjectMember;
import com.dongne.its.issue.repository.IssueRepository;
import com.dongne.its.member.domain.Member;
import com.dongne.its.member.repository.MemberRepository;
import com.dongne.its.project.converter.ProjectConverter;
import com.dongne.its.project.domain.Project;
import com.dongne.its.project.repository.ProjectRepository;
import com.dongne.its.project.web.dto.ProjectCreateRequestDto;
import com.dongne.its.project.web.dto.ProjectMemberAddRequestDto;
import com.dongne.its.project.web.dto.ProjectMemberRemoveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectCommandServiceImpl implements ProjectCommandService{

    private final ProjectRepository projectRepository;
    private final ProjectMemberRepository projectMemberRepository;
    private final MemberRepository memberRepository;
    private final IssueRepository issueRepository;

    @Override
    public Project removeMember(Long projectId, ProjectMemberRemoveRequestDto request) {
        Project project = projectRepository.findProjectById(projectId).orElseThrow();

        ProjectMember projectMember = project.getProjectMembers().stream()
                .filter(pm -> pm.getMember().getId().equals(request.getRemoveMemberId()))
                .findFirst()
                .orElseThrow();

        project.getProjectMembers().remove(projectMember);
        projectMemberRepository.delete(projectMember);
        return projectRepository.save(project);
    }


    @Override
    public Project addMember(Long projectId, ProjectMemberAddRequestDto request) {
        Project project = projectRepository.findProjectById(projectId).orElseThrow();
        Member member = memberRepository.findMemberById(request.getAddMemberId()).orElseThrow();

        ProjectMember projectMember = ProjectMember.builder()
                .project(project)
                .member(member)
                .build();

        project.getProjectMembers().add(projectMember);
        projectMemberRepository.save(projectMember);
        return projectRepository.save(project);
    }


    @Override
    public Project create(ProjectCreateRequestDto request) {
        Project project = ProjectConverter.toProject(request);
        project.setIsDeleted(false);
        projectRepository.save(project);

        List<ProjectMember> projectMembers = new ArrayList<>();
        for(Long memberId : request.getMemberIds()) {
            projectMembers.add(ProjectMember.builder()
                    .project(project)
                    .member(memberRepository.findMemberById(memberId).orElseThrow())
                    .build());
        }

        project.setProjectMembers(projectMembers);
        projectMemberRepository.saveAll(projectMembers);
        return projectRepository.save(project);
    }

    @Override
    public Project delete(Long projectId) {
        Project project = projectRepository.findProjectById(projectId).orElseThrow();

        project.setIsDeleted(true);
        project.getIssues().forEach(issue -> {
            issue.setIsDeleted(true);
            issue.setProject(null);
            issueRepository.save(issue);
        });
        return projectRepository.save(project);
    }
}
