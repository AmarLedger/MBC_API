package com.bezkoder.springjwt.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/*
 * @author Vivek Kumar
 * Since 17/07/2022
 */
@Entity
@Data
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long memId;

    @NotBlank
    @Size(max = 30)
    private String memberName;

    @NotBlank
    @Size(max = 50)
    @Email
    private String memberEmail;

    @NotBlank
    @Size(max = 11)
    private String memberPhone;

    @NotBlank
    @Size(max = 100)
    private String memberAddress;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberTransaction> memberTransactions = new ArrayList<>();

	public long getMemId() {
		return memId;
	}

	public void setMemId(long memId) {
		this.memId = memId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public List<MemberTransaction> getMemberTransactions() {
		return memberTransactions;
	}

	public void setMemberTransactions(List<MemberTransaction> memberTransactions) {
		this.memberTransactions = memberTransactions;
	}
    
}
