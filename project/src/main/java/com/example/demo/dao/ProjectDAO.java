package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.MemberVO;
import com.example.demo.dto.OrderformDetailVO;
import com.example.demo.dto.OrderformVO;
import com.example.demo.dto.QuotationVO;

@Mapper
public interface ProjectDAO {

	List<OrderformVO> orderformList();
	
	//월 매출
	public int getmonthlysales();
	//물품 구매 계약서
	List<OrderformVO> orderList();
	//물품 판매 계약서
	List<QuotationVO> quotationList();
	//All 계약서
	List<QuotationVO> AllFormList();
	//로그인
	MemberVO getMember(Map<String,Object> map);
	//회원가입
	int Postregister(Map<String,Object> map);
	   
	int checkMember_id(String member_id);
}
