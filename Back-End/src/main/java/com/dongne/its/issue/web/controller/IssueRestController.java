package com.dongne.its.issue.web.controller;

import com.dongne.its.issue.apiPayload.IssueApiResponse;
import com.dongne.its.issue.converter.IssueErrorConverter;
import com.dongne.its.issue.service.IssueQueryService;
import com.dongne.its.issue.web.dto.IssueExceptionDto;
import com.dongne.its.issue.web.dto.IssueResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/IssueError")
@RequiredArgsConstructor
public class IssueRestController {

  private final IssueQueryService issueQueryService;

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
