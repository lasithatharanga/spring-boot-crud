package com.nerdlk.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.nerdlk.spring.model.Member;
import com.nerdlk.spring.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("MemberController")
@RequestMapping("/api")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/members")
    public List<Member> all() {
        try {

            return memberService.getAllMembers();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/members")
    public ResponseEntity<Member> createMember(@Valid @RequestBody Member member) {
        return ResponseEntity.ok(memberService.saveMember(member));
    }

    @PutMapping("/members/{id}")
    public ResponseEntity<Member> updateMember(@Valid @RequestBody Member member, @PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(memberService.saveMember(member));
    }

    @DeleteMapping("/members/{id}")
    public ResponseEntity<?> deleteMember(@PathVariable(value = "id") Long id) {
        Map<String, String> response = new HashMap<String, String>();
        if (memberService.deleteMember(id)) {
            response.put("status", "success");
            response.put("message", "member deleted successfully");
            return ResponseEntity.ok(response);
        } else {
            response.put("status", "error");
            response.put("message", "Somthing went wrong when delete the member");
            return ResponseEntity.status(500).body(response);
        }
    }

    @GetMapping("/status")
    public String status() {
        System.out.println("hello");
        return "true";
    }
}