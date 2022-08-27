package com.bezkoder.springjwt.models;


import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

/*
 * @author Vivek Kumar
 * Since 17/07/2022
 */
@Data
public class MemberDto {
 private String memberName;

 @NotBlank
 @Size(max = 50)
 @Email
 private String memberEmail;

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
@NotBlank
 @Size(max = 11)
 private String memberPhone;
 private String memberAddress;

}
