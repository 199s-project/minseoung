package com.example.demo.dto;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Alias("PlandetailVO")
public class PlandetailVO {
	private int plan_num;
	private int pd_num;
	private String plan_name;
	private String plan_amount;
}
