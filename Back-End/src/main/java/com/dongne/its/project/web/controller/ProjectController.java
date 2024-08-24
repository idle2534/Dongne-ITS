package com.dongne.its.project.web.controller;

import com.dongne.its.base.apiPayload.code.ApiResponse;
import com.dongne.its.base.apiPayload.code.status.ErrorStatus;
import com.dongne.its.base.apiPayload.exception.handler.GeneralExceptionHandler;
import com.dongne.its.project.converter.ProjectConverter;
import com.dongne.its.project.domain.Project;
import com.dongne.its.project.service.ProjectCommandService;
import com.dongne.its.project.service.ProjectQueryService;
import com.dongne.its.project.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectCommandService projectCommandService;
    private final ProjectQueryService projectQueryService;

    //Put
    @PutMapping("/{projectId}")
    public ResponseEntity<String> update(@PathVariable("projectId") Long projectId) {
         Project project = projectCommandService.delete(projectId);
        return ApiResponse.onSuccess("Delete Success");
    }

    @PutMapping("/{projectId}/member/delete") // 멤버를 삭제한다
    public ResponseEntity<ProjectResponseDto> deleteMember(@PathVariable("projectId") Long projectId, @RequestBody ProjectMemberRemoveRequestDto request) {
        Project project = projectCommandService.removeMember(projectId, request);
        return ApiResponse.onSuccess(ProjectConverter.toProjectResponseDto(project));
    }

    @PutMapping("/{projectId}/member/add") // 멤버를 추가한다
    public ResponseEntity<ProjectResponseDto> addMember(@PathVariable("projectId") Long projectId, @RequestBody ProjectMemberAddRequestDto request) {
        Project project = projectCommandService.addMember(projectId, request);
        return ApiResponse.onSuccess(ProjectConverter.toProjectResponseDto(project));
    }

    //Post
    @PostMapping("/create") // project 를 생성한다
    public ResponseEntity<ProjectResponseDto> create(@RequestBody ProjectCreateRequestDto request) {
        Project project = projectCommandService.create(request);
        return ApiResponse.onSuccess(ProjectConverter.toProjectResponseDto(project));
    }

    //Get
    @GetMapping("/{projectId}") // project get
    public ResponseEntity<ProjectResponseDto> project(@PathVariable("projectId") Long projectId) {
        Project project = projectQueryService.findProjectById(projectId);
        return ApiResponse.onSuccess(ProjectConverter.toProjectResponseDto(project));
    }

    @GetMapping("")
    public ResponseEntity<List<ProjectResponseDto>> projects() {
        List<Project> projects = projectQueryService.findProjects();
        return ApiResponse.onSuccess(ProjectConverter.toProjectResponseDtoList(projects));
    }
}
