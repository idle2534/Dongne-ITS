package com.dongne.its.issue.web.dto;

import lombok.Getter;

@Getter
public class IssueCreateRequestDto {
  private String title;
  private String description;
  private Long projectId;
  private String category;
}
