package com.dongne.its.issue.web.dto;

import com.dongne.its.comment.web.dto.CommentResponseDto;
import com.dongne.its.member.web.dto.MemberResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

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
  private MemberResponseDto reporter;
  private String reportedDate;  //date-time
  private MemberResponseDto fixer;
  private MemberResponseDto assignee;
  private Long projectId;
  private String category;
  private List<CommentResponseDto> comments;
  private Boolean idDeleted;
}
