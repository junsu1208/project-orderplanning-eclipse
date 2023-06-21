package com.overc1ock.domain;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ProcurementPlanVO {
	
	private Integer pp_code;
	private Integer iup_code;
	private String item_code;
	private String item_name;
	private String process;
	private Date production_date;
	private Integer consumption;
	private String pp_text;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date procurement_date;
	private ArrayList<ProcurementPlanVO> procurementPlanVOList;
	
}
