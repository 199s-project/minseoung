package com.example.demo.dto;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Alias("RecipeVO")
public class RecipeVO {
	private int recipe_num;
	private int recipe_price;
	
	//recipedetail
	private int rd_num;
	private String product_name;
	private int material_amount;
	private int meterial_price;
	private String material_name;
	
	
	
	private int total_material_price;
	private int total_material_amount;
	private int total_recipe_price;
	
	// 추가
	private int inven_amount;
	
}
