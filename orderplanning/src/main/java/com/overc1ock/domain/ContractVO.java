package com.overc1ock.domain;

import java.text.SimpleDateFormat;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ContractVO {
	
	private Integer contract_code;
	private String contract_name;
	private String subcontractor_name;
	private String subcontractor_tel;
	private String subcontractor_email;
	private String subcontractor_person;
	private String product_name;
	private String item_code;
	private String item_name;
	private String standard;
	private String material;
	private String specification_file;
	private String draw_file;
	private Integer supply_price;
	private String agreement_date;
	private Integer leadtime;
	private String contract_file;
	private String contract_text;
	
	public String getAgreementDate() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		if (agreement_date == null) {
			return null;
		}
		return simpleDateFormat.format(agreement_date);
	}
	
}
