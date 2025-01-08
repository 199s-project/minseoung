package com.example.demo.dto;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Alias("PlandetailVO")
public class PlandetailVO {
	//plandetail
		private int plan_num;
		private int pd_num;
		private String plan_name;
		private int plan_maount;
}
