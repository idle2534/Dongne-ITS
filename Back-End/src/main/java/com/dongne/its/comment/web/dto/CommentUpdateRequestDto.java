package com.dongne.its.comment.web.dto;

import lombok.Getter;

@Getter
public class CommentUpdateRequestDto {
    private long commentId;
    private String content;
}
