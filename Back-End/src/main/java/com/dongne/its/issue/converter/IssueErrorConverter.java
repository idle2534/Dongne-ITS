package com.dongne.its.issue.converter;

import com.dongne.its.issue.web.dto.IssueExceptionDto;
import com.dongne.its.issue.web.dto.IssueResponseDto;

public class IssueErrorConverter {

  public static IssueResponseDto toIssueResponseDto(){
    return IssueResponseDto.builder()
        .id(123L)
        .title("test")
        .description("for test")
        .priority("TRIVIAL")
        .status("RESOLVED")
        .reportedDate("tempdate")
        .projectId(12345L)
        .category("test")
        .isDeleted(false)
        .build()
        ;
  }

  public static IssueExceptionDto toIssueExceptionDTO(Integer flag){
    return IssueExceptionDto.builder()
        .flag(flag)
        .build();
  }
}
