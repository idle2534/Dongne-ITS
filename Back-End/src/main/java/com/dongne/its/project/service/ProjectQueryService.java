package com.dongne.its.project.service;

import com.dongne.its.project.domain.Project;

import java.util.List;

public interface ProjectQueryService {
    public Project findProjectById(Long id);

    // public List<Project> findProjects();

    public Project findProjectByIdandProjectId(Long id, Long projectId);
}
