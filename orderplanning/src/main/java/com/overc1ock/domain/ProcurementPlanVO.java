package com.overc1ock.domain;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ProcurementPlanVO {
	
	private Integer pp_code;
	private Integer item_code;
	private String item_name;
	private String process;
	private Date production_date;
	private Integer consumption;
	private Date procurement_date;
	private String pp_text;
	
}
