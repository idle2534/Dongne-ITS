package com.dongne.its.issue.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IssueRecommendResponseDto {
  private IssueResponseDto issueResponseDto;
  private Long score;
  private Boolean isDeleted;
}
