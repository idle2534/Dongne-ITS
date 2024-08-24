package com.dongne.its.comment.service;


import com.dongne.its.comment.domain.Comment;

import java.util.List;

public interface CommentQueryService {

    public List<Comment> getComments(Long issueId);

}
