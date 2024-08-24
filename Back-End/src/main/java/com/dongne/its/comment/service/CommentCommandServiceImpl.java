package com.dongne.its.comment.service;

import com.dongne.its.comment.converter.CommentConverter;
import com.dongne.its.comment.domain.Comment;
import com.dongne.its.comment.repository.CommentRepository;
import com.dongne.its.comment.web.dto.CommentCreateRequestDto;
import com.dongne.its.comment.web.dto.CommentDeleteRequestDto;
import com.dongne.its.comment.web.dto.CommentUpdateRequestDto;
import com.dongne.its.issue.repository.IssueRepository;
import com.dongne.its.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentCommandServiceImpl implements CommentCommandService {

    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;
    private final IssueRepository issueRepository;

    @Override
    public Comment update(CommentUpdateRequestDto request) {
        Comment comment = commentRepository.findCommentById(request.getCommentId());
        comment.setContent(request.getContent());
        return commentRepository.save(comment);
    }

    @Override
    public Comment delete(CommentDeleteRequestDto request) {
        Comment comment = commentRepository.findCommentById(request.getCommentId());
        comment.setIsDeleted(true);
        comment.setIssue(null);
        return commentRepository.save(comment);
    }

    @Override
    public Comment create(Long id, CommentCreateRequestDto request) {
        Comment comment = CommentConverter.toComment(request);
        comment.setWriter(memberRepository.findMemberById(id).orElseThrow());
        comment.setIssue(issueRepository.findIssueById(request.getIssueId()).orElseThrow());
        comment.setIsDeleted(false);
        return commentRepository.save(comment);
    }
}
