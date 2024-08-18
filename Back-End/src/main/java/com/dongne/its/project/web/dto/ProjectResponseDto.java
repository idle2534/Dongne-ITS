package com.dongne.its.project.web.dto;

import com.dongne.its.issue.web.dto.IssueResponseDto;
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
public class ProjectResponseDto {
    private Long id;
    private String name;
    private List<MemberResponseDto> members;
    private List<IssueResponseDto> issues;
    private Long leaderId;
    private boolean isDeleted;
}
