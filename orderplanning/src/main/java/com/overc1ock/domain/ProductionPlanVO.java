package com.overc1ock.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ProductionPlanVO {
	
	Integer ppp_code;
	String product_name;
	Integer production;
	String process;
	String production_date;
	Date ppp_registration_date;
	
	public String getProductionDate() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		if (production_date == null) {
			return null;
		}
		return simpleDateFormat.format(production_date);
	}

}
