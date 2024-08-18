package com.dongne.its.project.web.controller;

import com.dongne.its.project.converter.ProjectConverter;
import com.dongne.its.project.domain.Project;
import com.dongne.its.project.service.ProjectCommandService;
import com.dongne.its.project.service.ProjectQueryService;
import com.dongne.its.project.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectQueryService projectQueryService;
    private final ProjectCommandService projectCommandService;

    //Put
    @PutMapping("/project/{projectId}")
    public ResponseEntity<String> update(@RequestParam Long id, @RequestParam Long projectId) {
        Project project = projectQueryService.findProjectByIdandProjectId(id, projectId);
        return ResponseEntity.ok("Success");
    }

    @PutMapping("/project/{projectId}/member/delete") // 멤버를 삭제한다
    public ResponseEntity<ProjectResponseDto> delete(@RequestBody ProjectMemberRemoveRequestDto request) {
        Project project = projectCommandService.memberRemove(request);
        return ResponseEntity.ok(ProjectConverter.toProjectResponseDto(project));
    }

    @PutMapping("/project/{projectId}/member/add") // 멤버를 추가한다
    public ResponseEntity<ProjectResponseDto> add(@RequestBody ProjectMemberAddRequestDto request) {
        Project project = projectCommandService.memberAdd(request);
        return ResponseEntity.ok(ProjectConverter.toProjectResponseDto(project));
    }

    //Get
    @GetMapping("/project/{projectId}") // project get
    public ResponseEntity<ProjectResponseDto> find(@RequestParam Long id, @RequestParam Long projectId) {
        Project project = projectQueryService.findProjectByIdandProjectId(id, projectId);
        return ResponseEntity.ok(ProjectConverter.toProjectResponseDto(project));
    }

    @GetMapping("/project")
    public ResponseEntity<ProjectResponseDto> find(@RequestParam Long id) {
        Project project = projectQueryService.findProjectById(id);
        return ResponseEntity.ok(ProjectConverter.toProjectResponseDto(project));
    }

    //Post
    @PostMapping("/project/create") // project 를 생성한다
    public ResponseEntity<ProjectResponseDto> create(@RequestBody ProjectCreateRequestDto request) {
        Project project = projectCommandService.create(request);
        return ResponseEntity.ok(ProjectConverter.toProjectResponseDto(project));
    }

}
