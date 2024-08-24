package com.dongne.its.comment.web.controller;

import com.dongne.its.base.apiPayload.code.ApiResponse;
import com.dongne.its.comment.converter.CommentConverter;
import com.dongne.its.comment.domain.Comment;
import com.dongne.its.comment.service.CommentCommandService;
import com.dongne.its.comment.service.CommentQueryService;
import com.dongne.its.comment.web.dto.CommentCreateRequestDto;
import com.dongne.its.comment.web.dto.CommentDeleteRequestDto;
import com.dongne.its.comment.web.dto.CommentResponseDto;
import com.dongne.its.comment.web.dto.CommentUpdateRequestDto;
import com.dongne.its.member.converter.MemberConverter;
import com.dongne.its.member.domain.Member;
import com.dongne.its.member.service.MemberCommandService;
import com.dongne.its.member.service.MemberQueryService;
import com.dongne.its.member.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentQueryService commentQueryService;
    private final CommentCommandService commentCommandService;

    //Put
    @PutMapping("/update")
    public ResponseEntity<CommentResponseDto> update(@RequestHeader("id") Long id, @RequestBody CommentUpdateRequestDto request) {
        Comment comment = commentCommandService.update(request);
        return ApiResponse.onSuccess(CommentConverter.toCommentResponseDto(comment));
    }

    @PutMapping("/delete")
    public ResponseEntity<String> delete(@RequestHeader("id") Long id, @RequestBody CommentDeleteRequestDto request) {
        Comment comment = commentCommandService.delete(request);
        return ApiResponse.onSuccess("Delete Success");
    }


    //Post
    @PostMapping("/create")
    public ResponseEntity<CommentResponseDto> create(@RequestHeader("id") Long id, @RequestBody CommentCreateRequestDto request) {
        Comment comment = commentCommandService.create(id, request);
        return ApiResponse.onSuccess(CommentConverter.toCommentResponseDto(comment));
    }


    //Get
    @GetMapping("/comment")
    public ResponseEntity<List<CommentResponseDto>> comment(@RequestHeader("id") Long id, @RequestParam("issueId") Long issueId) {
        List<Comment> comments = commentQueryService.getComments(issueId);
        return ApiResponse.onSuccess(CommentConverter.toCommentResponseDtoList(comments));
    }
}
