package com.dongne.its.comment.service;

import com.dongne.its.comment.domain.Comment;
import com.dongne.its.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentQueryServiceImpl implements CommentQueryService {

    private final CommentRepository commentRepository;

    @Override
    public List<Comment> getComments(Long issueId) {
        return commentRepository.findCommentsByIssueId(issueId);
    }
}
