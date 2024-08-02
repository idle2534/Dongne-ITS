package com.dongne.its.base.controller;

import com.dongne.its.base.domain.Project;
import com.dongne.its.base.service.common.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/create")
    public ResponseEntity<Project> createProject(@RequestBody CreateProjectRequest createProjectRequest) {
        Project project = new Project();
        project.setName(createProjectRequest.getName());
        project.setOwner(createProjectRequest.getOwner());
        project = projectService.save(project);
        return ResponseEntity.ok(project);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Project>> listProjects() {
        List<Project> projects = projectService.findAll();
        return ResponseEntity.ok(projects);
    }

    // DTO class for create project request
    public static class CreateProjectRequest {
        private String name;
        private String owner;

        // Getters and setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }
    }
}
