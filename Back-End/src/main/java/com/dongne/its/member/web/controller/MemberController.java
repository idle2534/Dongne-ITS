package com.dongne.its.member.web.controller;

import com.dongne.its.base.apiPayload.code.ApiResponse;
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
@RequestMapping("/api/v1/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberQueryService memberQueryService;
    private final MemberCommandService memberCommandService;


    //Put
    @PutMapping("/account/update")
    public ResponseEntity<MemberResponseDto> update(@RequestBody MemberRoleUpdateRequestDto request) {
        Member member_target = memberCommandService.updateRole(request);
        return ApiResponse.onSuccess(MemberConverter.toMemberResponseDto(member_target));
    }

    @PutMapping("/account/delete")
    public ResponseEntity<MemberResponseDto> delete(@RequestBody MemberDeleteRequestDto request) {
        Member member_target = memberCommandService.delete(request);
        return ApiResponse.onSuccess(MemberConverter.toMemberResponseDto(member_target));
    }


    //Post
    @PostMapping("/signUp")
    public ResponseEntity<MemberResponseDto> signUp(@RequestBody MemberSignUpRequestDto request) {
        Member member_target = memberCommandService.signUp(request);
        return ApiResponse.onSuccess(MemberConverter.toMemberResponseDto(member_target));
    }

    @PostMapping("/signIn")
    public ResponseEntity<MemberResponseDto> signIn(@RequestBody MemberSignInRequestDto request) {
        Member member = memberCommandService.signIn(request);
        return ApiResponse.onSuccess(MemberConverter.toMemberResponseDto(member));
    }

    @PostMapping("/createAdmin")
    public ResponseEntity<MemberResponseDto> createAdmin(@RequestBody MemberSignUpRequestDto request) {
        Member member = memberCommandService.createAdmin(request);
        return ApiResponse.onSuccess(MemberConverter.toMemberResponseDto(member));
    }


    //Get
    @GetMapping("/find")
    public ResponseEntity<MemberResponseDto> find(@RequestHeader("id") Long id) {
        Member member = memberQueryService.findMemberById(id);
        return ApiResponse.onSuccess(MemberConverter.toMemberResponseDto(member));
    }

    @GetMapping("/account")
    public ResponseEntity<List<MemberResponseDto>> account() {
        List<Member> member_target = memberQueryService.findMembers();
        return ApiResponse.onSuccess(MemberConverter.toMemberResponseDtoList(member_target));
    }

    @GetMapping("/account/project")
    public ResponseEntity<List<MemberResponseDto>> project(@RequestParam("projectId") Long projectId) {
        List<Member> member_target = memberQueryService.findMembersByProjectId(projectId);
        return ApiResponse.onSuccess(MemberConverter.toMemberResponseDtoList(member_target));
    }

    @GetMapping("/account/project/role")
    public ResponseEntity<List<MemberResponseDto>> role(@RequestParam("projectId") Long projectId, @RequestParam("role") String role) {
        List<Member> member_target = memberQueryService.findMembersByProjectIdAndRole(projectId, role);
        return ApiResponse.onSuccess(MemberConverter.toMemberResponseDtoList(member_target));
    }
}
