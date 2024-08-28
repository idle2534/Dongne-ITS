package com.dongne.its.comment.converter;

import com.dongne.its.comment.domain.Comment;
import com.dongne.its.comment.web.dto.CommentCreateRequestDto;
import com.dongne.its.comment.web.dto.CommentResponseDto;
import com.dongne.its.member.converter.MemberConverter;

import java.util.ArrayList;
import java.util.List;

public class CommentConverter {

    public static CommentResponseDto toCommentResponseDto(Comment comment){
        return comment == null ? null : CommentResponseDto.builder()
                .id(comment.getId())
                .writer(MemberConverter.toMemberResponseDto(comment.getWriter()))
                .content(comment.getContent())
                .isDeleted(comment.getIsDeleted())
                .build();
    }

    public static List<CommentResponseDto> toCommentResponseDtoList(List<Comment> comments){
        return comments == null ? new ArrayList<>() : comments.stream().map(comment ->
            CommentResponseDto.builder()
                .id(comment.getId())
                .writer(MemberConverter.toMemberResponseDto(comment.getWriter()))
                .content(comment.getContent())
                .isDeleted(comment.getIsDeleted())
                .build()).toList();
    }

    public static Comment toComment(CommentCreateRequestDto request){
        return Comment.builder()
                .content(request.getContent())
                .build();
    }
}
