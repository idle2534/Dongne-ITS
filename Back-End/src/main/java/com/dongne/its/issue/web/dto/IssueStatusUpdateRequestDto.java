package com.dongne.its.issue.web.dto;

import lombok.Getter;

@Getter
public class IssueStatusUpdateRequestDto {
  private Long issueId;
  private String status;  //enum
}
