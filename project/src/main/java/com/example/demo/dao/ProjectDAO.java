package com.example.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.CompanyVO;
import com.example.demo.dto.FileVO;
import com.example.demo.dto.InventoryVO;
import com.example.demo.dto.MemberVO;
import com.example.demo.dto.OrderformDetailVO;
import com.example.demo.dto.OrderformVO;
import com.example.demo.dto.ProductionDetailVO;
import com.example.demo.dto.ProductVO;
import com.example.demo.dto.ProductionVO;
import com.example.demo.dto.QuotationDetailVO;
import com.example.demo.dto.QuotationVO;
import com.example.demo.dto.RecipeDetailVO;

@Mapper
public interface ProjectDAO {

	MemberVO getMember(Map<String, Object> map);

	int postRegister(Map<String, Object> map);

	int checkMember_id(String member_id);

	List<OrderformVO> orderformList();

	int addCompany(CompanyVO companyVO);

	int addProduct(ProductVO productVO);

	int findMaxProductNum();

	int fileUpload(FileVO fileVO);

	int productCodeCheck(String product_code);

	String companyNameCheck(String company_name);

	int insertOrderform(OrderformVO orderformVO);

	int getLastOrderformNum();

	int insertOrderformDetail(OrderformDetailVO orderformDetailVO);

	int insertQuotation(QuotationVO quotationVO);

	int getLastQuotationNum();

	int insertQuotationDetail(QuotationDetailVO quotationDetailVO);

	ProductionVO getFactoryPlanDetail(int pd_num);

	CompanyVO getCompanyByCompanyName(String company_name);

	ProductVO getProductByProductName(String product_name);

	List<CompanyVO> getCompanyList();

	List<ProductVO> getProductList();

	// ------------ 김민성 ---------------------------------------------------------

	List<ProductionVO> getProductionList();

	int insertProductiondetail(List<ProductionDetailVO> list);

	int insertProduction(ProductionVO productionVO);

	int getfindLastProductionNumber();

	List<ProductionVO> getFatoryWorkList();

	List<ProductionVO> getFactoryDetailList(int pd_num);

	// 물품 구매 계약서
	List<OrderformVO> orderList();

	// 물품 판매 계약서
	List<QuotationVO> quotationList();

	// All 계약서
	List<QuotationVO> allFormList();

	int insertproductiondetail(List<ProductionDetailVO> list);

	ProductionVO getFactoryDetail(int pd_num);
	
	int getRecipeNumByProductName(String product_name);
	
	List<RecipeDetailVO> getRecipeDetailListByRecipeNum(int recipe_num);
	
	int reduceInventoryAmount(InventoryVO inventoryVO);
	
	// 추가분

	/*
	 *
	 * 
	 *//**
		 * product_name으로 recipe_num 조회
		 */
	/*
	 * Integer findRecipeNumByProductName(String productName);
	 * 
	 *//**
		 * recipe_num으로 recipedetail 정보 조회
		 *//*
			 * List<RecipeDetailVO> findRecipeDetailsByRecipeNum(int recipeNum);
			 * 
			 * void updateInventory(String materialName, int updatedInventory);
			 * 
			 * int findInventoryByMaterialName(String materialName);
			 * 
			 */

}
