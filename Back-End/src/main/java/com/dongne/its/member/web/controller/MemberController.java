package com.dongne.its.member.web.controller;

import com.dongne.its.member.converter.MemberConverter;
import com.dongne.its.member.domain.Member;
import com.dongne.its.member.service.MemberCommandService;
import com.dongne.its.member.service.MemberQueryService;
import com.dongne.its.member.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
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
        return ResponseEntity.ok(MemberConverter.toMemberResponseDto(member_target));
    }

    @PutMapping("/account/delete")
    public ResponseEntity<MemberResponseDto> delete(@RequestBody MemberDeleteRequestDto request) {
        Member member_target = memberCommandService.delete(request);
        return ResponseEntity.ok(MemberConverter.toMemberResponseDto(member_target));
    }

    //Post
    @PostMapping("/signUp")
    public ResponseEntity<MemberResponseDto> signUp(@RequestBody MemberSignUpRequestDto request) {
        Member member_target = memberCommandService.signUp(request);
        return ResponseEntity.ok(MemberConverter.toMemberResponseDto(member_target));
    }

    @PostMapping("/signIn")
    public ResponseEntity<MemberResponseDto> signIn(@RequestBody MemberSignInRequestDto request) {
        Member member = memberCommandService.signIn(request);
        System.out.println(MemberConverter.toMemberResponseDto(member).getId() + "/" + MemberConverter.toMemberResponseDto(member).getSignId() + "/" + MemberConverter.toMemberResponseDto(member).getRole());
        return ResponseEntity.ok(MemberConverter.toMemberResponseDto(member));
    }

    @PostMapping("/createAdmin")
    public ResponseEntity<MemberResponseDto> createAdmin(@RequestBody MemberSignUpRequestDto request) {
        Member member = memberCommandService.createAdmin(request);
        return ResponseEntity.ok(MemberConverter.toMemberResponseDto(member));
    }


    //Get
    @GetMapping("/find")
    public ResponseEntity<MemberResponseDto> find(@RequestParam Long id) {
        Member member = memberQueryService.findMemberById(id);
        return ResponseEntity.ok(MemberConverter.toMemberResponseDto(member));
    }

    @GetMapping("/account")
    public ResponseEntity<List<MemberResponseDto>> account() {
        List<Member> member = memberQueryService.findMembers();
        return ResponseEntity.ok(MemberConverter.toListMemberResponseDto(member));
    }

    @GetMapping("/account/project")
    public ResponseEntity<List<MemberResponseDto>> project(@RequestParam Long id, @RequestParam Long projectId) {
        List<Member> member = memberQueryService.findMembersByIdAndProjectId(id, projectId);
        return ResponseEntity.ok(MemberConverter.toListMemberResponseDto(member));
    }

    @GetMapping("/account/project/role")
    public ResponseEntity<List<MemberResponseDto>> role(@RequestParam Long id, @RequestParam Long projectId, @RequestParam String role) {
        List<Member> member = memberQueryService.findMembersByIdAndProjectIdAndRole(id, projectId, role);
        return ResponseEntity.ok(MemberConverter.toListMemberResponseDto(member));
    }
}
