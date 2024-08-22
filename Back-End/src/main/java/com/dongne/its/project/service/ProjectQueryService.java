package com.dongne.its.project.service;

import com.dongne.its.project.domain.Project;

import java.util.List;

public interface ProjectQueryService {

    public Project findProjectById(Long projectId);

    public List<Project> findProjects();
}
