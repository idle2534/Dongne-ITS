package com.dongne.its.issue.web.dto;

import lombok.Getter;

@Getter
public class IssueUpdateRequestDto {
  private Long issueId;
  private String description;
  private String status;  //enum
  private String priority;  //enum
  private String category;
}
