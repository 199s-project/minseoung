package com.example.demo.Contoller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.ProjectService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class homeController {
		

	private ModelAndView mv;
	
	@Autowired
	private ProjectService PService;
	
	 @GetMapping("/")
	   public ModelAndView Getlogin() {
	       mv = PService.Getlogin();
	       return mv;
	   }
	 @GetMapping("index")
	   public String index(Model model){
	      int wallsales = PService.getmonthlysales();
	      model.addAttribute("monthlysales",wallsales);
	      log.info("월 메출:{}",wallsales);
	       return "index";
	   }
	 @PostMapping("login")
	   public ModelAndView Postlogin(@RequestParam Map<String,Object> map,HttpSession session,Model model) {
		 int wallsales = PService.getmonthlysales();
	     model.addAttribute("monthlysales",wallsales);
	     log.info("월 메출:{}",wallsales);
		 mv = PService.Postlogin(map, session);
		   return mv;
	   }
	   
	  @GetMapping("logout")
	   public ModelAndView Getlogout(HttpSession session) {
	       mv =  PService.Getlogout(session);
	       return mv;
	  }
	    @GetMapping("register")
	    public String Getregister(){
	       log.info("register");
	       return "register";
	    }
	    
	    @PostMapping("register")
	    public ModelAndView Postregister(@RequestParam Map<String,Object> map) {
	    	mv = PService.Postregister(map);
	    	System.out.println(map);
	    	return mv;
	    }
	    
	    @GetMapping("/check-member_id")
	    public ResponseEntity<String> checkMember_id(@RequestParam("member_id") String member_id) {
	    	boolean isTaken = PService.isMember_idTaken(member_id);
	    	
	    	if (isTaken) {
	    		return ResponseEntity.ok("이미 사용중인 아이디입니다.");
	    	} else {
	    		return ResponseEntity.ok("사용 가능한 아이디입니다.");
	    	}
	    }
	
}
