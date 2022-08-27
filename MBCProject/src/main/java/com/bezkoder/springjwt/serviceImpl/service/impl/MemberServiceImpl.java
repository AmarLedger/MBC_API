package com.bezkoder.springjwt.serviceImpl.service.impl;




import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.springjwt.message.NoSuchRecordException;
import com.bezkoder.springjwt.models.Member;
import com.bezkoder.springjwt.models.MemberDto;
import com.bezkoder.springjwt.models.MemberTransaction;
import com.bezkoder.springjwt.models.MemberTransactionDto;
import com.bezkoder.springjwt.repository.MemberRepository;
import com.bezkoder.springjwt.repository.MemberTransactionRepository;
import com.bezkoder.springjwt.service.MemberService;

import lombok.AllArgsConstructor;



@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
@Autowired
    private MemberRepository memberRepository;
@Autowired
    private MemberTransactionRepository memberTransactionRepository;

    @Override
    public Member addMember(MemberDto memberDto) {
        Member member = new Member();
        BeanUtils.copyProperties(memberDto,member);
        return memberRepository.save(member);
    }

    @Override
    public Member updateMember(long memId, MemberDto memberDto) {
        return memberRepository.findById(memId)
                .map(member -> {
                    BeanUtils.copyProperties(memberDto,member);
                    return memberRepository.save(member);
                }).orElseThrow(() -> new NoSuchRecordException(String.format("No Member record found for memId:%s",memId)));
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member getMemberByPhone(String phone) {
        return memberRepository.findByMemberPhone(phone)
                .orElseThrow(() -> new NoSuchRecordException(String.format("No Record found for phone:%s",phone)));
    }

    @Override
    public MemberTransaction addTransactionByMemId(long memId, MemberTransactionDto transactionDto) {
        return memberRepository.findById(memId)
                .map(member -> {
                    MemberTransaction transaction = new MemberTransaction();
                    BeanUtils.copyProperties(transactionDto,transaction);
                    transaction.setMember(member);
                    transaction.setCreatedDate(LocalDateTime.now());
//                    member.getMemberTransactions().add(transaction);

                    return memberTransactionRepository.save(transaction);
                }).orElseThrow(() -> new NoSuchRecordException(String.format("No Record found against memId:%s",memId)));
    }

    @Override
    public void deleteMemberByMemId(long memId) {
        memberRepository.deleteById(memId);
    }

    @Override
    public List<MemberTransaction> getTransactionByMemId(long memId) {

        return memberRepository.findById(memId)
                .map(member -> member.getMemberTransactions())
                .orElseThrow(() -> new NoSuchRecordException(String.format("No Record found for memId:%s",memId)));
//    	Optional<Member> m= memberRepository.findById(memId);
    	
    }

    @Override
    public MemberTransaction updateTransactionByMemId(long memId, long trxId, MemberTransactionDto dto) {
           return memberTransactionRepository.findById(trxId)
                    .map(entity -> {
                        entity.setAmount(dto.getAmount());
                        entity.setBalance(dto.getBalance());
                        entity.setCredit(dto.getCredit());
                        entity.setDebit(dto.getDebit());
                        entity.setComments(dto.getComments());
                        entity.setTransactionDate(java.sql.Date.valueOf(dto.getTransactionDate()));
                        entity.setUpdatedBy(dto.getUpdatedBy());
                       
                        return memberTransactionRepository.save(entity);
                    }).orElseThrow(() -> new NoSuchRecordException(String.format("No such record found for trxId:%s",trxId)));
    }

    @Override
    public void deleteTransactionByMemId(long trxId) {
        memberTransactionRepository.deleteById(trxId);
    }
}
