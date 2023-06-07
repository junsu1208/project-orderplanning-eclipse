package com.overc1ock.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ProcurementPlanVO {

	private Long pp_code;
	private Long item_code;
	private String item_name;
	private String process;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date production_date;
	private int consumption;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date procurement_date;
	private String pp_text;
	
}
