package com.example.demo.dto;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Alias("RecipedetailVO")
public class RecipedetailVO {
	
	//recipedetail
		private int rd_num;
		private String meterial_name;
		private int material_amount;
		private int meterial_price;
		
		private int total_material_price;
		private int total_material_amount;
		private int total_recipe_price;
}
