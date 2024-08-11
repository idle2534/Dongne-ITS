package com.dongne.its.comment.web.dto;

import lombok.Getter;

@Getter
public class CommentCreateRequestDto {
    private Long issueId;
    private String content;
}
