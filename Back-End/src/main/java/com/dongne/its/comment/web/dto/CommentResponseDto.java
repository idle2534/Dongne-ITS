package com.dongne.its.comment.web.dto;

import com.dongne.its.member.web.dto.MemberResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponseDto {
    private Long id;
    private MemberResponseDto writer;
    private String content;
    private Boolean isDeleted;
}
