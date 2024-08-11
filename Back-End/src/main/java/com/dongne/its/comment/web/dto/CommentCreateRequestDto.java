package com.dongne.its.comment.web.dto;

import lombok.Getter;

@Getter
public class CommentCreateRequestDto {
    private long commentId;
    private String content;
}
