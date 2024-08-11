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
<<<<<<< HEAD
  private boolean isDeleted;
=======
  private boolean idDeleted;
>>>>>>> 9ace679e12894bb5f386cd28c28d9ad87ca67487
}
