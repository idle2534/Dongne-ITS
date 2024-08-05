package com.dongne.its.Member.controller;

import com.dongne.its.Member.domain.Member;
import com.dongne.its.Member.service.common.MemberService;
import com.dongne.its.Member.web.dto.MemberDeleteRequestDTO;
import com.dongne.its.Member.web.dto.MemberSignInRequestDTO;
import com.dongne.its.Member.web.dto.MemberSignUpRequestDTO;
import com.dongne.its.Member.web.dto.MemberUpdateRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/member")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/account")
    public ResponseEntity<List<Member>> getAllAccounts() {
        List<Member> members = memberService.findAll();
        return ResponseEntity.ok(members);
    }

    @PostMapping("/signIn")
    public ResponseEntity<Member> signIn(@RequestBody MemberSignInRequestDTO signInRequest) {
        Member member = memberService.findBySignId(signInRequest.getId());
        if (member != null && member.getPassword().equals(signInRequest.getPassword())) {
            return ResponseEntity.ok(member);
        } else {
            return ResponseEntity.status(401).body(null);
        }
    }

    @PostMapping("/signUp")
    public ResponseEntity<Member> signUp(@RequestBody MemberSignUpRequestDTO signUpRequest) {
        Member member = new Member();
        member.setId(signUpRequest.getId());
        member.setName(signUpRequest.getName());
        member.setPassword(signUpRequest.getPassword());
        member.setRole(signUpRequest.getRole());
        member = memberService.save(member);
        return ResponseEntity.ok(member);
    }

    @PutMapping("/update")
    public ResponseEntity<Member> updateAccount(@RequestBody MemberUpdateRequestDTO updateRequest) {
        Member member = memberService.findById(updateRequest.getId());
        if (member != null) {
            member.setRole(updateRequest.getRole());
            member = memberService.save(member);
            return ResponseEntity.ok(member);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    @PutMapping("/delete")
    public ResponseEntity<?> deleteAccount(@RequestBody MemberDeleteRequestDTO deleteRequest) {
        memberService.deleteById(deleteRequest.getId());
        return ResponseEntity.ok().build();
    }
}
