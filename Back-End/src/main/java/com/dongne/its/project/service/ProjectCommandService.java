package com.dongne.its.project.service;

import com.dongne.its.project.domain.Project;
import com.dongne.its.project.web.dto.ProjectCreateRequestDto;
import com.dongne.its.project.web.dto.ProjectMemberAddRequestDto;
import com.dongne.its.project.web.dto.ProjectMemberRemoveRequestDto;

public interface ProjectCommandService {


    public Project memberRemove(ProjectMemberRemoveRequestDto request);

    public Project memberAdd(ProjectMemberAddRequestDto request);

    public Project create(ProjectCreateRequestDto request);
}
