package com.overc1ock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ProcurementPlanVO {

	private Long pp_code;
	private Long item_code;
	private String item_name;
	private String process;
	private String production_date;
	private int consumption;
	private Date procurement_date;
	private String pp_text;
	
}
