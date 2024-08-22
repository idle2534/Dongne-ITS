package com.dongne.its.project.service;

import com.dongne.its.project.domain.Project;
import com.dongne.its.project.web.dto.ProjectCreateRequestDto;
import com.dongne.its.project.web.dto.ProjectMemberAddRequestDto;
import com.dongne.its.project.web.dto.ProjectMemberRemoveRequestDto;

public interface ProjectCommandService {

    public Project removeMember(Long projectId, ProjectMemberRemoveRequestDto request);

    public Project addMember(Long projectId, ProjectMemberAddRequestDto request);

    public Project create(ProjectCreateRequestDto request);

    public Project delete(Long projectId);
}
