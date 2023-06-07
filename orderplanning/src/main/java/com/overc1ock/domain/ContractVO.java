package com.overc1ock.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
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
	
	@Override
	public String toString() {
		return "ContractVO [contract_code=" + contract_code + ", contract_name=" + contract_name
				+ ", subconductor_name=" + subconductor_name + ", subconductor_tel=" + subconductor_tel
				+ ", subconductor_email=" + subconductor_email + ", subconductor_person=" + subconductor_person
				+ ", item_name=" + item_name + ", standard=" + standard + ", material=" + material
				+ ", specification_file=" + specification_file + ", draw_file=" + draw_file + ", supply_price="
				+ supply_price + ", agreement_date=" + agreement_date + ", leadtime=" + leadtime + ", contract_file="
				+ contract_file + ", contract_text=" + contract_text + "]";
	}
	
}
