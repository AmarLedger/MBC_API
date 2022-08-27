package com.bezkoder.springjwt.repository;


import com.bezkoder.springjwt.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;

/*
 * @author Vivek Kumar
 * Since 17/07/2022
 */
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByMemberPhone(String phone);
}
