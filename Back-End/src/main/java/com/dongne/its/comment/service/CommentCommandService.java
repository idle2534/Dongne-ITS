package com.dongne.its.comment.service;


import com.dongne.its.comment.domain.Comment;
import com.dongne.its.comment.web.dto.CommentCreateRequestDto;
import com.dongne.its.comment.web.dto.CommentDeleteRequestDto;
import com.dongne.its.comment.web.dto.CommentUpdateRequestDto;

public interface CommentCommandService {

    public Comment update(CommentUpdateRequestDto request);

    public Comment delete(CommentDeleteRequestDto request);

    public Comment create(Long id, CommentCreateRequestDto request);
}
