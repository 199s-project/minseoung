package com.example.demo.dto;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Alias("ProductVO")
public class ProductVO {
	private int product_num;
	private String product_name;
	private String product_code;
	private String product_brand;
	private String product_category;
	private String product_subcategory;
	private String product_stat;
	private int product_price;
	private int product_oprice;
	private String product_img;
}