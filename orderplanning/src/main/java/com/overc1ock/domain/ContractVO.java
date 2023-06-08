package com.overc1ock.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ContractVO {
	
	private String contract_name;
	private String subconductor_name;
	private String subconductor_tel;
	private String subconductor_email;
	private String subconductor_person;
	private String product_name;
	private String item_code;
	private String item_name;
	private String standard;
	private String material;
	private String specification_file;
	private String draw_file;
	private Integer supply_price;
	private Date agreement_date;
	private Integer leadtime;
	private String contract_file;
	private String contract_text;
	
}
