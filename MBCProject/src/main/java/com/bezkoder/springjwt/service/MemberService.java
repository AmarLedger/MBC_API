package com.bezkoder.springjwt.service;



import com.bezkoder.springjwt.models.Member;
import com.bezkoder.springjwt.models.MemberDto;
import com.bezkoder.springjwt.models.MemberTransaction;
import com.bezkoder.springjwt.models.MemberTransactionDto;

import java.util.List;

/*
 * @author Vivek Kumar
 * Since 17/07/2022
 */
public interface MemberService {

 Member addMember(MemberDto memberDto);

 Member updateMember(long memId, MemberDto memberDto);

 List<Member> getAllMembers();

 Member getMemberByPhone(String phone);

 MemberTransaction addTransactionByMemId(long memId, MemberTransactionDto transactionDto);

    void deleteMemberByMemId(long memId);

 List<MemberTransaction> getTransactionByMemId(long memId);

 MemberTransaction updateTransactionByMemId(long memId, long trxId, MemberTransactionDto dto);

 void deleteTransactionByMemId(long trxId);
}
