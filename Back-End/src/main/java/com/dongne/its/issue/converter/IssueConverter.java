package com.dongne.its.issue.converter;

import com.dongne.its.comment.converter.CommentConverter;
import com.dongne.its.issue.domain.Issue;
import com.dongne.its.issue.web.dto.IssueCreateRequestDto;
import com.dongne.its.issue.web.dto.IssueRecommendResponseDto;
import com.dongne.its.issue.web.dto.IssueResponseDto;
import com.dongne.its.member.converter.MemberConverter;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IssueConverter {
  public static IssueResponseDto toIssueResponseDto(Issue issue){
    if(issue == null) return null;

    return IssueResponseDto.builder()
        .id(issue.getId())
        .title(issue.getTitle())
        .description(issue.getDescription())
        .priority(String.valueOf(issue.getPriority()))
        .status(String.valueOf(issue.getStatus()))
        .reporter(MemberConverter.toMemberResponseDto(issue.getReporter()))
        .reportedDate(issue.getReportedDate())
        .fixer(MemberConverter.toMemberResponseDto(issue.getFixer()))
        .assignee(MemberConverter.toMemberResponseDto(issue.getAssignee()))
        .projectId(issue.getProject() != null ? issue.getProject().getId() : null)
        .category(issue.getCategory())
        .comments(CommentConverter.toCommentResponseDtoList(issue.getComments()))
        .isDeleted(issue.getIsDeleted())
        .build();
  }

  public static List<IssueResponseDto> toIssueResponseDtoList(List<Issue> issues){
    if(issues == null || issues.isEmpty()) return null;

    return issues.stream().map(issue -> IssueResponseDto.builder()
        .id(issue.getId())
        .title(issue.getTitle())
        .description(issue.getDescription())
        .priority(String.valueOf(issue.getPriority()))
        .status(String.valueOf(issue.getStatus()))
        .reporter(MemberConverter.toMemberResponseDto(issue.getReporter()))
        .reportedDate(issue.getReportedDate())
        .fixer(MemberConverter.toMemberResponseDto(issue.getFixer()))
        .assignee(MemberConverter.toMemberResponseDto(issue.getAssignee()))
        .projectId(issue.getProject() != null ? issue.getProject().getId() : null)
        .category(issue.getCategory())
        .comments(CommentConverter.toCommentResponseDtoList(issue.getComments()))
        .isDeleted(issue.getIsDeleted())
        .build()).toList();
  }

  public static List<IssueRecommendResponseDto> toIssueRecommendResponseDtoList(List<Issue> issues, List<Long> scores){
    if (issues == null || scores == null) return null;

    return IntStream.range(0, issues.size())
            .mapToObj(i -> IssueRecommendResponseDto.builder()
                    .issueResponseDto(IssueConverter.toIssueResponseDto(issues.get(i)))
                    .score(scores.get(i))
                    .isDeleted(false)
                    .build())
            .sorted(Comparator.comparing(IssueRecommendResponseDto::getScore)).limit(3).toList();
  }


  public static Issue toIssue(IssueCreateRequestDto request){
    return Issue.builder()
        .title(request.getTitle())
        .description(request.getDescription())
        .category(request.getCategory())
        .build();
  }

}
