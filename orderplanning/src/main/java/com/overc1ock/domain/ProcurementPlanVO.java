package com.overc1ock.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ProcurementPlanVO {
	
	private Long item_code;
	private String item_name;
	private String process;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date production_date;
	private int consumption;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date procurement_date;
	private String pp_text;
	
	@Override
	public String toString() {
		return "ProcurementPlanVO [item_code=" + item_code + ", item_name=" + item_name + ", process=" + process
				+ ", production_date=" + production_date + ", consumption=" + consumption + ", procurement_date="
				+ procurement_date + ", pp_text=" + pp_text + "]";
	}
	
}
