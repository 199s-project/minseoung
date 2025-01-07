package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.ProjectDAO;
import com.example.demo.dto.MemberVO;
import com.example.demo.dto.OrderformVO;
import com.example.demo.dto.QuotationVO;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProjectService {

	private ModelAndView mv;
	
	@Autowired
	private ProjectDAO pDAO;
	
	public List<OrderformVO> orderformList(){
		log.info("orderformList()");
		return pDAO.orderformList();
	}
	public int getmonthlysales() {
		log.info("getmonthlysales");
		return pDAO.getmonthlysales();
	}
	
	public List<OrderformVO> orderList(){
		log.info("orderList()");
		return pDAO.orderList();
	}
	public List<QuotationVO> quotationList(){
		log.info("quotationList()");
		return pDAO.quotationList();
	}
	public List<QuotationVO> AllFormList(){
		log.info("AllFormList()");
		return pDAO.AllFormList();
	}
	public ModelAndView Getlogin() {
	       mv = new ModelAndView();
	       mv.setViewName("login");
	       return mv;
	   }
	    
	    public ModelAndView Postlogin(@RequestParam Map<String,Object> map,HttpSession session) {
	    	mv = new ModelAndView();
	    	MemberVO member = pDAO.getMember(map);
	    	
	    	if (member == null) {
	    		mv.addObject("msg", "로그인에 실패하였습니다.");
	    		mv.setViewName("login");
	    		return mv;
	    	}
	    	 
	    	session.setAttribute("user", member); 
	        mv.setViewName("index");
	    	
	    	return mv;
	    }
	    
	    public ModelAndView Getlogout(HttpSession session) {
	    	mv = new ModelAndView();
	    	session.invalidate();
	    	mv.setViewName("login");
	    	return mv;
	    }
	    public ModelAndView Postregister(
	    		Map<String,Object> map
	    		) {
	    	mv = new ModelAndView();
	    	int r = pDAO.Postregister(map);
	    	
	    	if (r == 1) {
	    		mv.addObject("msg", "회원가입 성공");
	    		mv.setViewName("login");
	    		return mv;
	    	} 
	    	
	    	mv.addObject("msg", "회원가입 실패. 다시 진행해주세요.");
	    	mv.setViewName("register");
	    	return mv;
	    }
	    
	    public boolean isMember_idTaken(String member_id) {
	    	return pDAO.checkMember_id(member_id) > 0;
	    }
	
}
