package com.dongne.its.comment.web.controller;

import com.dongne.its.comment.domain.Comment;
import com.dongne.its.comment.service.CommentService;
import com.dongne.its.comment.web.dto.CommentCreateRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/create")
    public ResponseEntity<Comment> createComment(@RequestBody CommentCreateRequestDto dto) {
        Comment comment = commentService.createComment(dto);
        return ResponseEntity.ok(comment);
    }
}
