package com.example.demo.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.OrderformVO;
import com.example.demo.dto.ProductionVO;
import com.example.demo.service.ProjectService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {

	@Autowired
	private ProjectService projectService;
	
	
	
	//0203 김민성
	@GetMapping("/")
    public String Home(Model model){
		
		
        log.info("Home");
        
        List<ProductionVO> list = projectService.getLastProduction();
        model.addAttribute("list", list); 
        
        return "index";
    }
	
	//0203 김민성
	@ResponseBody
    @GetMapping("/chartdata")
    public Map<String,Object> getChartData() {
    	
    	 int black = projectService.getPdCheckCount1();
    	 int white = projectService.getPdCheckCount2();
    	 
    	 System.out.println(black);
    	 System.out.println(white);
    	 
         
    	Map<String,Object> chartdata = new HashMap<>();
    	chartdata.put("black",black);
    	chartdata.put("white",white);
    	
        return chartdata;
    }
	
	
    
    
}
