package com.example.demo.dto;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Alias("ProductionPlanVO")
public class ProductionPlanVO {
	private int pd_num;
	private String pd_writedate;
	private String pd_writer;
	private String pd_dept;
	private String pd_startdate;
	private String pd_enddate;
	private String pd_production;
	private String pd_content;
	
	//plandetail
	private int plan_num;
	private String plan_name;
	private int plan_maount;
}
