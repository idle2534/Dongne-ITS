package com.dongne.its.project.service;

import com.dongne.its.project.domain.Project;
import com.dongne.its.project.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProjectQueryServiceImpl implements ProjectQueryService {

    private final ProjectRepository projectRepository;

    @Override
    public Project findProjectById(Long projectId) {
        return projectRepository.findProjectById(projectId).orElseThrow();
    }

    @Override
    public List<Project> findProjects() {
        return projectRepository.findProjects();
    }
}
