package com.dongne.its.project.service;

import com.dongne.its.project.domain.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProjectQueryServiceImpl implements ProjectQueryService {

    @Override
    public Project findProjectById(Long id) {

        return null;
    }

    @Override
    public Project findProjectByIdandProjectId(Long id, Long projectId) {

        return null;
    }

}
