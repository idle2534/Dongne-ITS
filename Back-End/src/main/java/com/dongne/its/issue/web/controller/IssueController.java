package com.dongne.its.issue.web.controller;

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

@RestController
@RequestMapping("/api/v1/issue")
@RequiredArgsConstructor
public class IssueController {

  private final IssueQueryService issueQueryService;
  private final IssueCommandService issueCommandService;

  //Put
  @PutMapping("/update")
  public ResponseEntity<IssueResponseDto> update(@RequestBody IssueUpdateRequestDto request){
    Issue issue_target = issueCommandService.updateIssue(request);
    return ResponseEntity.ok(IssueConverter.toIssueResponseDto(issue_target));
  }

  @PutMapping("/update/dev")
  public ResponseEntity<IssueResponseDto> dev(@RequestBody IssueStatusUpdateRequestDto request){
    Issue issue_target = issueCommandService.updateIssueDev(request);
    return null;
  }

  @PutMapping("/reassign")
  public ResponseEntity<IssueResponseDto> reassign(@RequestBody IssueAssignRequestDto request){
    Issue issue_target = issueCommandService.reassign(request);
    return null;
  }

  @PutMapping("/deleteRequest")
  public ResponseEntity<IssueResponseDto> deleteRequest(@RequestBody IssueDeleteRequestDto request){
    Issue issue_target = issueCommandService.deleteRequest(request);
    return null;
  }

  @PutMapping("/deleteRequest/delete")
  public ResponseEntity<IssueResponseDto> delete(@RequestBody IssueDeleteRequestDto request){
    Issue issue_target = issueCommandService.delete(request);
    return null;
  }

  @PutMapping("/assign")
  public ResponseEntity<IssueResponseDto> assign(@RequestBody IssueAssignRequestDto request){
    Issue issue_target = issueCommandService.assign(request);
    return null;
  }


  //Post
  @PostMapping("/create")
  public ResponseEntity<IssueResponseDto> create(@RequestBody IssueCreateRequestDto request){
    Issue issue_target = issueCommandService.create(request);
    return null;
  }


  //Get
  @GetMapping("")
  public ResponseEntity<IssueResponseDto> issue(@RequestParam Long issueId){
    Issue issue_target = issueQueryService.findIssueByIssueId(issueId);
    return null;
  }

  @GetMapping("/{projectId}")
  public ResponseEntity<IssueResponseDto> findIssueByProjectId(@PathVariable("projectId") Long projectId){
    Issue issue_target = issueQueryService.findIssueByProjectId(projectId);
    return null;
  }


  @GetMapping("/{projectId}/tester")
  public ResponseEntity<IssueResponseDto> findTesterByProjectId(@PathVariable("projectId") Long projectId){
    Issue issue_target = issueQueryService.findTesterByProjectId(projectId);
    return null;
  }

  @GetMapping("/{projectId}/dev")
  public ResponseEntity<IssueResponseDto> findDevByProjectId(@PathVariable("projectId") Long projectId){
    Issue issue_target = issueQueryService.findDevByProjectId(projectId);
    return null;
  }

  @GetMapping("/search")
  public ResponseEntity<IssueResponseDto> search(@RequestHeader("id") Long id, @RequestParam("category") String category, @RequestParam("projectId") Long projectId, @RequestParam("keyword") String keyword){
    Issue issue_target = issueQueryService.search(id, category, projectId, keyword);
    return null;
  }

  @GetMapping("/issueRecommend")
  public ResponseEntity<IssueResponseDto> recommend(@RequestHeader("id") Long id, @RequestParam("issueId") Long issueId){
    Issue issue_target = issueQueryService.recommend(id, issueId);
    return null;
  }

  @GetMapping("/deleteRequest/find")
  public ResponseEntity<IssueResponseDto> deleteFind(@RequestParam("id") Long id){
    Issue issue_target = issueQueryService.deleteFind(id);
    return null;
  }

  @GetMapping("/all")
  public ResponseEntity<IssueResponseDto> all(@RequestHeader("id") Long id){
    Issue issue_target = issueQueryService.all(id);
    return null;
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
