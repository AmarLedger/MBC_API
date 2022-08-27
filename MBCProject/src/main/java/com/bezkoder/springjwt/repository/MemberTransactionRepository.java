package com.bezkoder.springjwt.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.springjwt.models.MemberTransaction;

/*
 * @author Vivek Kumar
 * Since 19/07/2022
 */
public interface MemberTransactionRepository extends JpaRepository<MemberTransaction, Long> {

}
