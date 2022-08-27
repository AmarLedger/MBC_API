package com.bezkoder.springjwt.controllers;




import java.util.List;

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

import com.bezkoder.springjwt.models.Member;
import com.bezkoder.springjwt.models.MemberDto;
import com.bezkoder.springjwt.models.MemberTransaction;
import com.bezkoder.springjwt.models.MemberTransactionDto;
import com.bezkoder.springjwt.service.MemberService;

import lombok.Data;

/*
 * @author Vivek Kumar
 * Since 17/07/2022
 */
@RestController
@Data
@RequestMapping("/api")
public class MemberLedgerAccountController {
	@Autowired
   MemberService memberService;

    @PostMapping("/member")
    public ResponseEntity<Member> addMember(@RequestBody MemberDto memberDto) {
        return ResponseEntity.ok(memberService.addMember(memberDto));
    }

    @PutMapping("/member/{memId}")
    public ResponseEntity<Member> updateMember(@PathVariable long memId, @RequestBody MemberDto memberDto) {
        return ResponseEntity.ok(memberService.updateMember(memId, memberDto));
    }

    @GetMapping("/member/all")
    public ResponseEntity<List<Member>> getAllMembers() {
        return ResponseEntity.ok(memberService.getAllMembers());
    }

    @GetMapping("/member/{phone}")
    public ResponseEntity<Member> getMemberByPhone(@PathVariable String phone) {
        return ResponseEntity.ok(memberService.getMemberByPhone(phone));
    }

    @DeleteMapping("/member/{memId}")
    public ResponseEntity<?> deleteMemberByMemId(@PathVariable long memId) {
        memberService.deleteMemberByMemId(memId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/member/{memId}/transaction")
    public ResponseEntity<MemberTransaction> addTransactionByMemId(@PathVariable long memId, @RequestBody MemberTransactionDto transactionDto) {
        System.out.println("addTransactionByMemId");
        return ResponseEntity.ok(memberService.addTransactionByMemId(memId,transactionDto));
    }

    @GetMapping("/member/{memId}/transaction")
    public ResponseEntity<List<MemberTransaction>> getTransactionByMemId(@PathVariable long memId) {
        System.out.println("getTransactionByMemId");
        return ResponseEntity.ok(memberService.getTransactionByMemId(memId));
    }

    @PutMapping("/member/{memId}/transaction/{trxId}")
    public ResponseEntity<MemberTransaction> updateTransactionByMemId(@PathVariable long memId, @PathVariable long trxId, @RequestBody MemberTransactionDto dto) {
        return ResponseEntity.ok(memberService.updateTransactionByMemId(memId, trxId, dto));
    }

    @DeleteMapping("/member/transaction/{trxId}")
    public ResponseEntity<?> deleteTransactionByMemId(@PathVariable long trxId) {
        memberService.deleteTransactionByMemId(trxId);
        return ResponseEntity.noContent().build();
    }
}
