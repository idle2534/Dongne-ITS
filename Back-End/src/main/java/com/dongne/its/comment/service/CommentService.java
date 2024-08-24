package com.dongne.its.comment.service;

import com.dongne.its.comment.domain.Comment;
import com.dongne.its.comment.repository.CommentRepository;
import com.dongne.its.issue.domain.Issue;
import com.dongne.its.issue.repository.IssueRepository;
import com.dongne.its.comment.web.dto.CommentCreateRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final IssueRepository issueRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, IssueRepository issueRepository) {
        this.commentRepository = commentRepository;
        this.issueRepository = issueRepository;
    }

    public Comment createComment(CommentCreateRequestDto dto) {
        Issue issue = issueRepository.findById(dto.getIssueId())
                .orElseThrow(() -> new IllegalArgumentException("Issue not found"));

        Comment comment = new Comment(issue, dto.getContent());
        return commentRepository.save(comment);
    }

    // Method to fetch comments by issue ID
    public List<Comment> getCommentsByIssueId(Long issueId) {
        return commentRepository.findByIssueId(issueId);
    }
}
