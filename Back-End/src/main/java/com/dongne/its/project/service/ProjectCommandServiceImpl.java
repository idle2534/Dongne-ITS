package com.dongne.its.project.service;

import com.dongne.its.project.domain.Project;
import com.dongne.its.project.web.dto.ProjectCreateRequestDto;
import com.dongne.its.project.web.dto.ProjectMemberAddRequestDto;
import com.dongne.its.project.web.dto.ProjectMemberRemoveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectCommandServiceImpl implements ProjectCommandService{

    @Override
    public Project memberRemove(ProjectMemberRemoveRequestDto request) {

        return null;
    }

    @Override
    public Project memberAdd(ProjectMemberAddRequestDto request) {

        return null;
    }

    @Override
    public Project create(ProjectCreateRequestDto request) {

        return null;
    }
}
