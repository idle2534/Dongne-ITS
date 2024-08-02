package com.dongne.its.base.controller;

import com.dongne.its.base.domain.Member;
import com.dongne.its.base.service.common.MemberService;
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
    public ResponseEntity<Member> signIn(@RequestBody SignInRequest signInRequest) {
        Member member = memberService.findBySignId(signInRequest.getSignId());
        if (member != null && member.getPassword().equals(signInRequest.getPassword())) {
            return ResponseEntity.ok(member);
        } else {
            return ResponseEntity.status(401).body(null);
        }
    }

    @PostMapping("/signUp")
    public ResponseEntity<Member> signUp(@RequestBody SignUpRequest signUpRequest) {
        Member member = new Member();
        member.setSignId(signUpRequest.getSignId());
        member.setName(signUpRequest.getName());
        member.setPassword(signUpRequest.getPassword());
        member.setRole(signUpRequest.getRole());
        member = memberService.save(member);
        return ResponseEntity.ok(member);
    }

    @PutMapping("/update")
    public ResponseEntity<Member> updateAccount(@RequestBody UpdateRequest updateRequest) {
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
    public ResponseEntity<?> deleteAccount(@RequestBody DeleteRequest deleteRequest) {
        memberService.deleteById(deleteRequest.getId());
        return ResponseEntity.ok().build();
    }

    // DTO classes for requests
    public static class SignInRequest {
        private String signId;
        private String password;

        // Getters and setters
        public String getSignId() {
            return signId;
        }

        public void setSignId(String signId) {
            this.signId = signId;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    public static class SignUpRequest {
        private String signId;
        private String name;
        private String password;
        private String role;

        // Getters and setters
        public String getSignId() {
            return signId;
        }

        public void setSignId(String signId) {
            this.signId = signId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }

    public static class UpdateRequest {
        private Long id;
        private String role;

        // Getters and setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }

    public static class DeleteRequest {
        private Long id;

        // Getters and setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }
}
