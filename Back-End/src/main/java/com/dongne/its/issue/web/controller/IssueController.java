package com.dongne.its.issue.web.controller;

import com.dongne.its.base.apiPayload.code.ApiResponse;
import com.dongne.its.issue.apiPayload.IssueApiResponse;
import com.dongne.its.issue.converter.IssueConverter;
import com.dongne.its.issue.converter.IssueErrorConverter;
import com.dongne.its.issue.domain.Issue;
import com.dongne.its.issue.service.IssueCommandService;
import com.dongne.its.issue.service.IssueQueryService;
import com.dongne.its.issue.web.dto.IssueAssignRequestDto;
import com.dongne.its.issue.web.dto.IssueCreateRequestDto;
import com.dongne.its.issue.web.dto.IssueDeleteRequestDto;
import com.dongne.its.issue.web.dto.IssueExceptionDto;
import com.dongne.its.issue.web.dto.IssueResponseDto;
import com.dongne.its.issue.web.dto.IssueStatusUpdateRequestDto;
import com.dongne.its.issue.web.dto.IssueUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/issue")
@RequiredArgsConstructor
public class IssueController {

  private final IssueQueryService issueQueryService;
  private final IssueCommandService issueCommandService;

  //Put
  @PutMapping("/update")
  public ResponseEntity<IssueResponseDto> update(@RequestHeader("id") Long id, @RequestBody IssueUpdateRequestDto request){
    Issue issue_target = issueCommandService.updateIssue(request);
    return ApiResponse.onSuccess(IssueConverter.toIssueResponseDto(issue_target));
  }

  @PutMapping("/update/dev")
  public ResponseEntity<IssueResponseDto> dev(@RequestHeader("id") Long id, @RequestBody IssueStatusUpdateRequestDto request){
    Issue issue_target = issueCommandService.updateIssueDev(request);
    return ApiResponse.onSuccess(IssueConverter.toIssueResponseDto(issue_target));
  }

  @PutMapping("/reassign")
  public ResponseEntity<IssueResponseDto> reassign(@RequestHeader("id") Long id, @RequestBody IssueAssignRequestDto request){
    Issue issue_target = issueCommandService.reassign(request);
    return ApiResponse.onSuccess(IssueConverter.toIssueResponseDto(issue_target));
  }

  @PutMapping("/deleteRequest")
  public ResponseEntity<IssueResponseDto> deleteRequest(@RequestHeader("id") Long id, @RequestBody IssueDeleteRequestDto request){
    Issue issue_target = issueCommandService.deleteRequest(request);
    return ApiResponse.onSuccess(IssueConverter.toIssueResponseDto(issue_target));
  }

  @PutMapping("/deleteRequest/delete")
  public ResponseEntity<IssueResponseDto> delete(@RequestHeader("id") Long id, @RequestBody IssueDeleteRequestDto request){
    Issue issue_target = issueCommandService.delete(request);
    return ApiResponse.onSuccess(IssueConverter.toIssueResponseDto(issue_target));
  }

  @PutMapping("/assign")
  public ResponseEntity<IssueResponseDto> assign(@RequestHeader("id") Long id, @RequestBody IssueAssignRequestDto request){
    Issue issue_target = issueCommandService.assign(request);
    return ApiResponse.onSuccess(IssueConverter.toIssueResponseDto(issue_target));
  }


  //Post
  @PostMapping("/create")
  public ResponseEntity<IssueResponseDto> create(@RequestHeader("id") Long id, @RequestBody IssueCreateRequestDto request){
    Issue issue_target = issueCommandService.create(id, request);
    return ApiResponse.onSuccess(IssueConverter.toIssueResponseDto(issue_target));
  }


  //Get
  @GetMapping("")
  public ResponseEntity<IssueResponseDto> issue(@RequestHeader("id") Long id, @RequestParam("issueId") Long issueId){
    Issue issue_target = issueQueryService.findIssueById(issueId);
    return ApiResponse.onSuccess(IssueConverter.toIssueResponseDto(issue_target));
  }

  @GetMapping("/{projectId}")
  public ResponseEntity<List<IssueResponseDto>> findIssueByProjectId(@RequestHeader("id") Long id, @PathVariable("projectId") Long projectId){
    List<Issue> issues_target = issueQueryService.findIssueByProjectId(projectId);
    return ApiResponse.onSuccess(IssueConverter.toListIssueResponseDto(issues_target));
  }


  @GetMapping("/{projectId}/tester")
  public ResponseEntity<List<IssueResponseDto>> findTesterByProjectId(@RequestHeader("id") Long id, @PathVariable("projectId") Long projectId){
    List<Issue> issues_target = issueQueryService.findTesterByProjectId(projectId);
    return ApiResponse.onSuccess(IssueConverter.toListIssueResponseDto(issues_target));
  }

  @GetMapping("/{projectId}/dev")
  public ResponseEntity<List<IssueResponseDto>> findDevByProjectId(@RequestHeader("id") Long id, @PathVariable("projectId") Long projectId){
    List<Issue> issues_target = issueQueryService.findDevByProjectId(projectId);
    return ApiResponse.onSuccess(IssueConverter.toListIssueResponseDto(issues_target));
  }

  @GetMapping("/search")
  public ResponseEntity<List<IssueResponseDto>> search(@RequestHeader("id") Long id, @RequestParam("category") String category, @RequestParam("projectId") Long projectId, @RequestParam("keyword") String keyword){
    List<Issue> issues_target = issueQueryService.search(id, category, projectId, keyword);
    return ApiResponse.onSuccess(IssueConverter.toListIssueResponseDto(issues_target));
  }

  @GetMapping("/issueRecommend")
  public ResponseEntity<List<IssueResponseDto>> recommend(@RequestHeader("id") Long id, @RequestParam("issueId") Long issueId){
    List<Issue> issues_target = issueQueryService.recommend(id, issueId);
    return ApiResponse.onSuccess(IssueConverter.toListIssueResponseDto(issues_target));
  }

  @GetMapping("/deleteRequest/find")
  public ResponseEntity<List<IssueResponseDto>> deleteFind(@RequestParam("id") Long id){
    List<Issue> issues_target = issueQueryService.deleteFind(id);
    return ApiResponse.onSuccess(IssueConverter.toListIssueResponseDto(issues_target));
  }

  @GetMapping("/all")
  public ResponseEntity<List<IssueResponseDto>> all(@RequestHeader("id") Long id){
    List<Issue> issues_target = issueQueryService.all(id);
    return ApiResponse.onSuccess(IssueConverter.toListIssueResponseDto(issues_target));
  }





























  @GetMapping("/test")
  public IssueApiResponse<IssueResponseDto> testAPI(){

    return IssueApiResponse.onSuccess(IssueErrorConverter.toIssueResponseDto());
  }

  @GetMapping("/exception")
  public IssueApiResponse<IssueExceptionDto> exceptionAPI(@RequestParam Integer flag){
    issueQueryService.CheckFlag(flag);
    return IssueApiResponse.onSuccess(IssueErrorConverter.toIssueExceptionDTO(flag));
  }
}
