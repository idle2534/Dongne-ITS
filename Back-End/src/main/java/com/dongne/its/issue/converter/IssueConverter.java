package com.dongne.its.issue.converter;

import com.dongne.its.issue.domain.Issue;
import com.dongne.its.issue.web.dto.IssueCreateRequestDto;
import com.dongne.its.issue.web.dto.IssueResponseDto;
import com.dongne.its.member.converter.MemberConverter;
import java.util.List;

public class IssueConverter {
  public static IssueResponseDto toIssueResponseDto(Issue issue){
    return IssueResponseDto.builder()
        .id(issue.getId())
        .title(issue.getTitle())
        .description(issue.getDescription())
        .priority(String.valueOf(issue.getPriority()))
        .status(String.valueOf(issue.getStatus()))
        .reporter(MemberConverter.toMemberResponseDto(issue.getReporter()))
        .fixer(MemberConverter.toMemberResponseDto(issue.getFixer()))
        .assignee(MemberConverter.toMemberResponseDto(issue.getAssignee()))
//        .projectId(ProjectConverter.toProjectResponseDto(issue.getProject()))
        .category(issue.getCategory())
//        .comments(CommentConverter.toCommentResponseDto(issue.getComments()))
        .isDeleted(issue.isDeleted())
        .build();
  }

  public static List<IssueResponseDto> toListIssueResponseDto(List<Issue> issues){
    return issues.stream().map(issue -> IssueResponseDto.builder()
        .id(issue.getId())
        .title(issue.getTitle())
        .description(issue.getDescription())
        .priority(String.valueOf(issue.getPriority()))
        .status(String.valueOf(issue.getStatus()))
        .reporter(MemberConverter.toMemberResponseDto(issue.getReporter()))
        .fixer(MemberConverter.toMemberResponseDto(issue.getFixer()))
        .assignee(MemberConverter.toMemberResponseDto(issue.getAssignee()))
//        .projectId(ProjectConverter.toProjectResponseDto(issue.getProject()))
        .category(issue.getCategory())
//        .comments(CommentConverter.toCommentResponseDto(issue.getComments()))
        .isDeleted(issue.isDeleted())
        .build()).toList();
  }

  public static Issue toIssue(IssueCreateRequestDto request){
    return Issue.builder()
        .title(request.getTitle())
        .description(request.getDescription())
//      .projectId(ProjectConverter.toProjectResponseDto(request.getProject()))
        .category(request.getCategory())
        .build();
  }

}
