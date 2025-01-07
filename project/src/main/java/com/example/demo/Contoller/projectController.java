package com.example.demo.Contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.CompanyVO;
import com.example.demo.dto.OrderformVO;
import com.example.demo.dto.ProductVO;
import com.example.demo.dto.QuotationVO;
import com.example.demo.service.ProjectService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class projectController {

	@Autowired
	private ProjectService PService;
   

   
   @GetMapping("index2")
   public String index2(){
       log.info("index2");
       return "index2";
   }
   
   @GetMapping("form-basic")
   public String form_basic(){
       log.info("aaaaa");
       return "form-basic";
   }
   
   @GetMapping("advanced-components")
   public String advanced_components(){
       log.info("advanced-components");
       return "advanced-components";
   }

   @GetMapping("form-wizard")
   public String form_wizard(){
       log.info("form-wizard");
       return "form-wizard";
   }
   
   @GetMapping("html5-editor")
   public String html5_editor(){
       log.info("html5-editor");
       return "html5-editor";
   }
   
   @GetMapping("form-pickers")
   public String form_pickers(){
       log.info("form-pickers");
       return "form-pickers";
   }
   
   @GetMapping("image-cropper")
   public String image_cropper(){
       log.info("image-cropper");
       return "image-cropper";
   }
   
   @GetMapping("image-dropzone")
   public String image_dropzone(){
       log.info("image-dropzone");
       return "image-dropzone";
   }
   
   @GetMapping("basic-table")
   public String basic_table(){
       log.info("basic-table");
       return "basic-table";
   }
   
   @GetMapping("datatable")
   public String datatable(){
       log.info("datatable");
       return "datatable";
   }
   
   
   
   
   @GetMapping("quotation")
   public String quotation(Model model){
       log.info("quotation");
       
       List<OrderformVO> list = PService.orderformList();
       model.addAttribute("orderform", list);
       
       
       return "quotation";
   }
   
   @GetMapping("quotation-detail")
   public String quotation_detail(){
       log.info("quotation");
       
       return "quotation-detail";
   }   
   
   
   
   
   
   
   
   @GetMapping("calendar")
   public String calendar(){
       log.info("calendar");
       return "calendar";
   }
   
   @GetMapping("ui-buttons")
   public String ui_buttons(){
       log.info("ui-buttons");
       return "ui-buttons";
   }
   
   @GetMapping("ui-cards")
   public String ui_cards(){
       log.info("ui-cards");
       return "ui-cards";
   }
   
   @GetMapping("ui-cards-hover")
   public String ui_cards_hover(){
       log.info("ui-cards-hover");
       return "ui-cards-hover";
   }
   
   @GetMapping("ui-modals")
   public String ui_modals(){
       log.info("ui-modals");
       return "ui-modals";
   }
   
   @GetMapping("ui-tabs")
   public String ui_tabs(){
       log.info("ui-tabs");
       return "ui-tabs";
   }
   
   @GetMapping("ui-tooltip-popover")
   public String ui_tooltip_popover(){
       log.info("ui-tooltip-popover");
       return "ui-tooltip-popover";
   }
   
   @GetMapping("ui-sweet-alert")
   public String ui_sweet_alert(){
       log.info("ui-sweet-alert");
       return "ui-sweet-alert";
   }
   
   @GetMapping("ui-notification")
   public String ui_notification(){
       log.info("ui-notification");
       return "ui-notification";
   }
   
   @GetMapping("ui-timeline")
   public String ui_timeline(){
       log.info("ui-timeline");
       return "ui-timeline";
   }
   
   @GetMapping("ui-progressbar")
   public String ui_progressbar(){
       log.info("ui-progressbar");
       return "ui-progressbar";
   }
   
   @GetMapping("ui-typography")
   public String ui_typography(){
       log.info("ui-typography");
       return "ui-typography";
   }
   
   @GetMapping("ui-list-group")
   public String ui_list_group(){
       log.info("ui-list-group");
       return "ui-list-group";
   }
   
   @GetMapping("ui-range-slider")
   public String ui_range_slider(){
       log.info("ui-range-slider");
       return "ui-range-slider";
   }
   
   @GetMapping("ui-carousel")
   public String ui_carousel(){
       log.info("ui-carousel");
       return "ui-carousel";
   }
   
   @GetMapping("font-awesome")
   public String font_awesome(){
       log.info("font-awesome");
       return "font-awesome";
   }
   
   @GetMapping("foundation")
   public String foundation(){
       log.info("foundation");
       return "foundation";
   }
   
   @GetMapping("ionicons")
   public String ionicons(){
       log.info("ionicons");
       return "ionicons";
   }
   
   @GetMapping("themify")
   public String themify(){
       log.info("themify");
       return "themify";
   }
   
   @GetMapping("custom-icon")
   public String custom_icon(){
       log.info("custom-icon");
       return "custom-icon";
   }
   
   @GetMapping("highchart")
   public String highchart(){
       log.info("highchart");
       return "highchart";
   }
   
   @GetMapping("knob-chart")
   public String knob_chart(){
       log.info("knob-chart");
       return "knob-chart";
   }
   
   @GetMapping("jvectormap")
   public String jvectormap(){
       log.info("jvectormap");
       return "jvectormap";
   }
   
   @GetMapping("apexcharts")
   public String apexcharts(){
       log.info("apexcharts");
       return "apexcharts";
   }
   
   @GetMapping("video-player")
   public String video_player(){
       log.info("video-player");
       return "video-player";
   }
   
   @GetMapping("login")
   public String login(){
       log.info("login");
       return "login";
   }
   
   @GetMapping("forgot-password")
   public String forgot_password(){
       log.info("forgot-password");
       return "forgot-password";
   }
   
   @GetMapping("reset-password")
   public String reset_password(){
       log.info("reset-password");
       return "reset-password";
   }
   
   @GetMapping("blank")
   public String blank(){
       log.info("blank");
       return "blank";
   }
   
   @GetMapping("contact-directory")
   public String contact_directory(){
       log.info("contact-directory");
       return "contact-directory";
   }
   
   @GetMapping("blog")
   public String blog(){
       log.info("blog");
       return "blog";
   }
   
   @GetMapping("blog-detail")
   public String blog_detail(){
       log.info("blog-detail");
       return "blog-detail";
   }
   
   @GetMapping("product")
   public String product(){
       log.info("product");
       return "product";
   }
   
   @GetMapping("product-detail")
   public String product_detail(){
       log.info("product-detail");
       return "product-detail";
   }
   
   @GetMapping("faq")
   public String faq(){
       log.info("faq");
       return "faq";
   }
   
   @GetMapping("profile")
   public String profile(){
       log.info("profile");
       return "profile";
   }
   
   @GetMapping("gallery")
   public String gallery(){
       log.info("gallery");
       return "gallery";
   }
   
   @GetMapping("pricing-table")
   public String pricing_table(){
       log.info("pricing-table");
       return "pricing-table";
   }
   @GetMapping("riterForm")
	public String riterForm() {
		return "riterForm";
	}
 

   @GetMapping("productionPlan")
   public String productionPlan() {
	   log.info("productionPlan()");
	   return "productionPlan";
   }
   @GetMapping("purchaseContract")
   public String purchaseContract(Model model) {
	   
	   List<OrderformVO> list = PService.orderList();
       model.addAttribute("orderList", list);
       log.info("list",list);
       return "purchaseContract";
       
   }
   @GetMapping("salesContract")
   public String salesContractList(Model model) {
	   
	   List<QuotationVO> list = PService.quotationList();
       model.addAttribute("quotationList", list);
       log.info("list",list);
	   return "salesContract";
   }
   
   @GetMapping("AllForm")
   public String AllFormList(Model model) {
	   
		  List<QuotationVO> list = PService.AllFormList();
		  model.addAttribute("AllFormList", list);
		  log.info("AllFormList",list);
       return "AllForm";
   }
   @GetMapping("productionForm")
   public String productionForm() {
	   log.info("productionForm()");
	   return "productionForm";
   }
	/*
	 * @GetMapping("getproductionPlanRegister") public String
	 * getproductionPlanRegister() throws Exception { mv = new ModelAndView();
	 * List<CompanyVO> companies = ProjectService.get(); List<ProductVO> products =
	 * ProjectService.GetProductList(); String productsJson = new
	 * ObjectMapper().writeValueAsString(products); mv.addObject("products",
	 * products); mv.addObject("productsJson", productsJson);
	 * mv.addObject("companies", companies); mv.setViewName("orderformregister");
	 * 
	 * return mv; }
	 */
}
