package com.example.demo.Contoller;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.CompanyVO;
import com.example.demo.dto.FileVO;
import com.example.demo.dto.InventoryVO;
import com.example.demo.dto.OrderformVO;
import com.example.demo.dto.ProductionDetailVO;
import com.example.demo.dto.ProductVO;
import com.example.demo.dto.ProductionVO;
import com.example.demo.dto.QuotationVO;
import com.example.demo.dto.RecipeVO;
import com.example.demo.dto.RecipeDetailVO;
import com.example.demo.service.ProjectService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ProjectController {

	private static final ProductionDetailVO[] productionDetails = null;

	private ModelAndView mv;
	
	@Autowired
	private ProjectService projectService;

	// 홈 화면 (index.html) 이동
	@GetMapping("index")
	public String index(){
	    log.info("index");
	    return "index";
	}
	
	// 로그인화면 이동
	@GetMapping("login")
	public ModelAndView getLogin() {
		mv = projectService.getLogin();
		return mv;
	}
   
	// 로그인
	@PostMapping("login")
	public ModelAndView postLogin(@RequestParam Map<String,Object> map,HttpSession session) {
		mv = projectService.postLogin(map, session);
		return mv;
	}
   
	// 로그아웃
	@GetMapping("logout")
	public String getLogout(HttpSession session) {
		mv = projectService.getLogout(session);
		return "login";
	}
	
	// 회원가입 화면 이동
	@GetMapping("register")
	public String getRegister(){
		log.info("register");
		return "register";
	}
   
	// 회원가입
	@PostMapping("register")
	public ModelAndView postRegister(@RequestParam Map<String,Object> map) {
		mv = projectService.postRegister(map);
		System.out.println(map);
		return mv;
	}
   
	
	// 아이디 중복검사
	@GetMapping("/check-member_id")
	public ResponseEntity<String> checkMember_id(@RequestParam("member_id") String member_id) {
		boolean isTaken = projectService.isMember_idTaken(member_id);
   	
		if (isTaken) {
			return ResponseEntity.ok("이미 사용중인 아이디입니다.");
		} else {
			return ResponseEntity.ok("사용 가능한 아이디입니다.");
		}
	}
   
   
   
	
	

	

	
	
    // 비어있는 페이지
	@GetMapping("notepad")
	public String notepad(){
	    log.info("notepad");
	    return "notepad";
	}	
	
	// 구매계약서 상세 화면 이동
	@GetMapping("quotationDetail")
	public String quotationDetail(){
	    log.info("quotationDetail");
	    
	    return "quotationDetail";
	}	
	
	// company(협력사) 등록 화면 이동
	@GetMapping("companyRegister")
	public String companyRegister(){
	    log.info("companyRegister");
	    
	    return "companyRegister";
	}
	
	// company 등록
	@PostMapping("addCompany")
	public String addCompany(@RequestBody CompanyVO companyVO){
	    String name = companyVO.getCompany_name();
	    log.info("Company's name is : "+ name);
	    int r = projectService.addCompany(companyVO);
	    return "index";
	}
	
	// 제품 등록 화면 이동
	@GetMapping("productRegister")
	public String productRegister(){
	    log.info("productRegister");
	    
	    return "productRegister";
	}
	
	// 제품 등록
    @PostMapping("/addProduct")
    public ResponseEntity<?> addProduct(@RequestBody ProductVO productVO) {
        try {
            // 제품 정보 저장 로직 (예: DB 저장)
            // productService.save(request);
            int r = projectService.addProduct(productVO);
            // 성공 메시지 반환
            return ResponseEntity.ok(Map.of("message", "Product added successfully"));
        } catch (Exception e) {
            // 오류 발생 시 JSON 에러 메시지 반환
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(Map.of("error", "Failed to add product"));
        }
    }

	

	// 파일(이미지) 업로드를 위한 경로지정
	@Value("${org.zerock.upload.path}")
	private String uploadPath;
	
	// 파일 업로드
    @PostMapping(value = "imageUpload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> imageUpload(@RequestParam(value="fileVO") MultipartFile[] files) {
    	
        try {
        	// 제품의 pk값이 auto-increment로 되어있기 때문에 여기에 1를 더해서 지금 등록한 제품의 pk값을 찾아오려는 과정
        	String maxnum = ""+projectService.findMaxProductNum();
        	
        	// 멀티업로드된 파일 리스트에서 각각의 파일에 대해 데이터베이스에 등록하는 과정
        	for (MultipartFile file : files) {
        		
        		String originalName = file.getOriginalFilename();
        		String uuid = UUID.randomUUID().toString();
        		String uploadName = uuid + "_" + originalName;
        		
        		Path savePath = Paths.get(uploadPath, uploadName);
        		file.transferTo(savePath);
  			
        		FileVO VO = new FileVO();
  			
        		VO.setFile_name(uploadName);
        		VO.setFile_path("/C:\\uploads/" + uploadName);
        		VO.setFile_subject("product");
        		VO.setFile_pk(maxnum);
  			
        		int r = projectService.fileUpload(VO);
        	}
            // 성공 메시지 반환
            return ResponseEntity.ok(Map.of("message", "File added successfully"));
            
        } catch (Exception e) {
            // 오류 발생 시 JSON 에러 메시지 반환
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(Map.of("error", "Failed to add file"));
        }
        
    }
    
    // 제품 등록 시 제품코드 중복확인
    @ResponseBody
	@PostMapping("productCodeCheck")
	public int productCodeCheck(@RequestParam("product_code") String product_code) {
	    int cnt = projectService.productCodeCheck(product_code);
	    return cnt;
	}
    
    // 제품 등록 시 입력한 것과 가장 일치하는 협력사 이름을 찾는 과정
    @ResponseBody
	@PostMapping("companyNameCheck")
	public String companyNameCheck(@RequestParam("company_name") String company_name) {
    	company_name = company_name + "%";
	    String company = projectService.companyNameCheck(company_name);
	    return company;
	}
	
    // 구매계약서 등록 화면 이동
    @GetMapping("getOrderformRegister")
    public ModelAndView getOrderformRegister() throws Exception {
    	mv = projectService.getOrderformRegister();
        return mv;
    }
    
    // 구매계약서 등록
    @PostMapping("postOrderformRegister")
    public ModelAndView postOrderformRegister(@RequestParam Map<String,Object> map) throws Exception {
    	
    	mv = projectService.postOrderformRegister(map);
    	
        return mv;
    }
    
    // 판매계약서 등록 화면 이동
    @GetMapping("getQuotationRegister")
    public ModelAndView getQuotationRegister() throws Exception {
    	mv = projectService.getQuotationRegister();
        return mv;
    }
    
    // 판매계약서 등록
    @PostMapping("postQuotationRegister")
    public ModelAndView postQuotationRegister(
 		   @RequestParam Map<String,Object> map
 		   ) throws Exception {
 	   mv = projectService.postQuotationRegister(map);
 	   return mv;
    }
    
    // 입력한 회사명으로 해당 회사의 정보들을 불러오는 과정
    @GetMapping("/getCompanyByCompanyName")
    public ResponseEntity<CompanyVO> getCompanyByCompanyName(
          @RequestParam("company_name") String company_name
          ) {
       CompanyVO company = projectService.getCompanyByCompanyName(company_name);
       
       return ResponseEntity.ok(company);
    }

    
    // 입력한 제품명으로 해당 제품의 정보들을 불러오는 과정
    @GetMapping("/getProductByProductName")
    public ResponseEntity<ProductVO> getProductByProductName(
          @RequestParam("product_name") String product_name
          ) {
       ProductVO product = projectService.getProductByProductName(product_name);
       
       return ResponseEntity.ok(product);
    }
    
  

	
	 
	 
  
	
	 
    
    @ResponseBody
    @GetMapping("/getCompanyNameList")
    public String[] getCompanyNameList(Model model) {
       log.info("controller access");
       List<CompanyVO> companyList = projectService.getCompanyList();
       
       String[] companyNameList = new String[companyList.size()];
       int cnt = 0;
       for (CompanyVO company : companyList) {
          companyNameList[cnt] = company.getCompany_name();
          cnt++;
       }
       model.addAttribute("companyNameList",companyNameList);
       
        return companyNameList;
    }
   
    
    @ResponseBody
    @GetMapping("/getProductNameList")
    public String[] getProductNameList(Model model) {
       log.info("controller access");
       List<ProductVO> productList = projectService.getProductList();
       
       String[] productNameList = new String[productList.size()];
       int cnt = 0;
       for (ProductVO product : productList) {
          productNameList[cnt] = product.getProduct_name();
          cnt++;
       }
       model.addAttribute("productNameList",productNameList);
       
        return productNameList;
    }
	
	
    
    //================ 김민성 ============================================================================
    
    // 생산계획서 폼 upload
    @PostMapping("postProductionForm")
    public String postProductionForm(@RequestParam Map<String,Object> formData) {
    		log.info("formData",formData);
    	ProductionVO productionVO = new ProductionVO();
    	productionVO.setPd_writer((String)formData.get("pd_writer"));
    	productionVO.setPd_dept((String)formData.get("pd_dept"));
    	productionVO.setPd_startdate((String)formData.get("pd_startdate"));
    	productionVO.setPd_enddate((String)formData.get("pd_enddate"));
    	productionVO.setPd_name((String)formData.get("pd_name"));
    	productionVO.setPd_content((String)formData.get("pd_content"));
    	
    	projectService.insertProduction(productionVO);
    	
    	int num = (int) projectService.getfindLastProductionNumber();
    	//num 은 pd_num 생성되자마자 넣음
    	//============================================================= 여기까지는 바로 진행해야함.
    	//maxCount 추출
    	int maxCount = Integer.parseInt((String) formData.get("maxCount"));
    	// num = pd_num 
    	System.out.println(maxCount);
    	
    	List<ProductionDetailVO> list = new ArrayList<>();
    	
    	for(int i =1; i<=maxCount;i++) {
    		String itemNameKey = "item_name" + i ; 
    		String quantityKey = "quantity" + i ;
    		log.info(itemNameKey);
    		log.info(quantityKey);
    		
    		if(formData.containsKey(itemNameKey) && formData.containsKey(quantityKey)) {
    			String itemName = (String) formData.get(itemNameKey);
    			int quantity = Integer.parseInt((String) formData.get(quantityKey));
    			
    			ProductionDetailVO planVO = new ProductionDetailVO();
    			planVO.setPd_num(num);
    			planVO.setProduct_name(itemName);
    			planVO.setProductiondetail_amount(quantity);
    			
    			list.add(planVO);
    		}
    	}
    
    	list.forEach(planVO ->
    		log.info("list -> Pd num: {}, Item Name: {},Quantity: {}",planVO.getPd_num(), planVO.getProduct_name(), planVO.getProductiondetail_amount())
    			);
    	
    	int r = projectService.setproductionForm(list);
		  
 	   return "redirect:productionPlan";
    }
    // 구매계약서 목록 화면 이동
    @GetMapping("purchaseContract")
    public String purchaseContract(Model model) {
 	   
    	List<OrderformVO> list = projectService.orderList();
        model.addAttribute("orderList", list);
        log.info("list",list);
        return "purchaseContract";
        
    }
    
    // 판매계약서 목록 화면 이동
    @GetMapping("salesContract")
    public String salesContractList(Model model) {
 	   
 	   List<QuotationVO> list = projectService.quotationList();
        model.addAttribute("quotationList", list);
        log.info("list",list);
 	   return "salesContract";
    }
    
    // 모든 계약서들의 목록을 볼 수 있는 화면 이동
    @GetMapping("allForm")
    public String allFormList(Model model) {
    	List<QuotationVO> list = projectService.allFormList();
    	model.addAttribute("AllFormList", list);
    	log.info("allFormList",list);
        return "allForm";
    }
	// 생산계획서 목록 화면 이동
    @GetMapping("productionPlan")
    public String getproductionPlanList(Model model) {
 	   
 	   List<ProductionVO> list = projectService.getProductionList();
 	   model.addAttribute("getProductionPlanList", list);
 	  log.info("getProductionPlanList",list);
 	   return "productionPlan";
    }
	// 생산계획서 폼 이동
    @GetMapping("productionForm")
    public String productionForm() {
 	   
 	  log.info("productionForm()");
 	   return "productionForm";
    }
   
    //facotry.html
    @GetMapping("factoryPlan")
    public String factoryPlan(Model model) {
    	List<ProductionVO> list = projectService.getProductionList();
    	model.addAttribute("getProductionPlanList", list);
    	  log.info("factoryPlan",list);
    	return "factoryPlan";
    }
    @GetMapping("getFactoryDetail")
    public ModelAndView getFactoryDetail(@RequestParam("pd_num") int pd_num) {
    	
    	ProductionVO productionVO = new ProductionVO();
    	productionVO = projectService.getFactoryDetail(pd_num);
    	List<ProductionVO> productionListVO = projectService.getFactoryDetailList(pd_num);
    	
    	mv = new ModelAndView();
    	mv.addObject("productionVO",productionVO);
    	mv.addObject("productionList",productionListVO);
    	mv.setViewName("factoryDetail");
    	
    	
    
    	return mv;
    }
    
    @PostMapping("postFactoryDetail")
    public String postFactoryDetail(@RequestParam Map<String,Object> formData) {
    	
        Map<String,Object> itemData = formData.entrySet()
                .stream()
                .filter(entry -> entry.getKey().contains("item_name"))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
          
          Optional<Integer> itemMaxNumber = itemData.keySet()
                .stream()
                .filter(key -> key.startsWith("item_name"))
                .map(key -> Integer.parseInt(key.replace("item_name", "")))
                .max(Integer::compareTo);
         
          
        int maxCount = itemMaxNumber.orElse(0);
        
    	int num = (int) projectService.getfindLastProductionNumber();
    	
    	for(int i =1; i<=maxCount;i++) {
    		String itemNameKey = "item_name" + i ; 
    		String quantityKey = "quantity" + i ;
    		
    		String itemName = (String) formData.get(itemNameKey);
    		int quantity = Integer.parseInt((String) formData.get(quantityKey));
    		
		
			 log.info(itemNameKey);
			 log.info(quantityKey);
			 
    		
    		int recipe_num = projectService.getRecipeNumByProductName(itemName);
    		List<RecipeDetailVO> list = projectService.getRecipeDetailListByRecipeNum(recipe_num);
    		int listSize = list.size();
    		
    		for(int k =1; k<=listSize;k++) {
    			 int Mamount =list.get(k-1).getMaterial_amount();
    			String Mname = list.get(k-1).getMaterial_name();
    			InventoryVO inventoryVO = new InventoryVO();
    			
    			int totalMamount = Mamount * quantity ; 
    		
    			inventoryVO.setInven_amount(totalMamount);
    			inventoryVO.setInven_name(Mname);
    			
    			int r = projectService.reduceInventoryAmount(inventoryVO);
    		}
    		
    	}
    		
    	return "redirect:factoryPlan";
    }
    

	
}
