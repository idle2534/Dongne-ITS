package com.dongne.its.comment.web.dto;

import lombok.Getter;

@Getter
public class CommentUpdateRequestDto {
    private Long commentId;
    private String content;
}
