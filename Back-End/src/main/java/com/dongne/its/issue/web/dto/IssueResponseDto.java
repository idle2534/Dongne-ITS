package com.dongne.its.issue.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class IssueResponseDto {
  private Long id;
  private String title;
  private String description;
  private String priority;  //enum
  private String status;  //enum
  private String reportedDate;  //date-time
  private Long projectId;
  private String category;
  private boolean idDeleted;
}
