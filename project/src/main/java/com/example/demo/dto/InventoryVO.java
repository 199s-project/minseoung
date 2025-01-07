package com.example.demo.dto;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Alias("InventoryVO")
public class InventoryVO {
	
	public int inventory_num;
	public String inventory_name;
	public int inventory_price;
	public int inventory_amount;
	public String inventory_regdate;
	
}
