package com.dongne.its.project.service;

import com.dongne.its.project.domain.Project;
import com.dongne.its.project.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProjectQueryServiceImpl implements ProjectQueryService {

    private final ProjectRepository projectRepository;
    @Override
    public Project findProjectById(Long id) {

        return projectRepository.findProjectById(id).orElseThrow();
    }


    // Swagger 를 바탕으로 작성은 했는데 Project 에서 id 와 projectId 의 차이를 모르겠다... 문제가 없으면 다행이지만 문제가 생길 확률이 높다
    @Override
    public Project findProjectByIdandProjectId(Long id, Long projectId) {

        return projectRepository.findProjectByIdandProjectId(id, projectId).orElseThrow();
    }

}
