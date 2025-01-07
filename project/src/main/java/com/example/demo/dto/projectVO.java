package com.example.demo.dto;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Alias("LoginVO")
public class projectVO {
	private int member_num;	//근로자 번호
	private String member_id;	//근로자 아이디
	private String member_pwd;	//근로자 비밀번호
	private String member_email;	//근로자 이메일
	private String member_phone;	//근로자 전화번호
	private String member_grade;	//근로자 직급
	private String member_dept;	//근로자 부서명
}
