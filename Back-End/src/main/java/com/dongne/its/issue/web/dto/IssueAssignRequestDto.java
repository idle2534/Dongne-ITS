package com.dongne.its.issue.web.dto;

import lombok.Getter;

@Getter
public class IssueAssignRequestDto {
  private Long issueId;
  private Long assigneeId;
}
