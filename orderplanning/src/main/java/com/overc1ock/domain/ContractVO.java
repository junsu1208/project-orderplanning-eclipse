package com.overc1ock.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ContractVO {
	
	private Long contract_code;
	private String contract_name;
	private String subconductor_name;
	private String subconductor_tel;
	private String subconductor_email;
	private String subconductor_person;
	private String item_name;
	private String standard;
	private String material;
	private String specification_file;
	private String draw_file;
	private int supply_price;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date agreement_date;
	private int leadtime;
	private String contract_file;
	private String contract_text;

}
