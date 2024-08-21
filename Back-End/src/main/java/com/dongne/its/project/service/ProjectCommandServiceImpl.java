package com.dongne.its.project.service;

import com.dongne.its.base.Repository.ProjectMembersRepository;
import com.dongne.its.base.domain.mapping.ProjectMembers;
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
    private final ProjectMembersRepository projectMembersRepository;
    private final MemberRepository memberRepository;

    @Override
    public Project memberRemove(ProjectMemberRemoveRequestDto request, Long projectId) {
        Project project = projectRepository.findById(projectId).orElseThrow();
        Member member = memberRepository.findById(request.getRemoveMemberId()).orElseThrow();

        ProjectMembers projectMember = project.getProjectMembers().stream()
                .filter(pm -> pm.getMember().equals(member))
                .findFirst()
                .orElseThrow();

        project.getProjectMembers().remove(projectMember);
        projectMembersRepository.delete(projectMember);
        projectRepository.save(project);
        return project;
    }


    @Override
    public Project memberAdd(ProjectMemberAddRequestDto request, Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow();
        Member member = memberRepository.findById(request.getAddMemberId())
                .orElseThrow();

        ProjectMembers projectMember = ProjectMembers.builder()
                .project(project)
                .member(member)
                .build();

        project.getProjectMembers().add(projectMember);
        projectMembersRepository.save(projectMember);
        projectRepository.save(project);

        return project;
        }


    @Override
    public Project create(ProjectCreateRequestDto request) {
        Project project = ProjectConverter.toProject(request);
        System.out.println("MemberID" + request.getMemberIds());
        projectRepository.save(project);

        List<ProjectMembers> projectMembers = new ArrayList<>();
        for(Long memberId : request.getMemberIds()) {
            projectMembers.add(ProjectMembers.builder()
                    .project(project)
                    .member(memberRepository.findMemberById(memberId).orElseThrow())
                    .build());
        }
        projectMembersRepository.saveAll(projectMembers);

        project.setProjectMembers(projectMembers);

        projectRepository.save(project);

        return project;
    }
}
