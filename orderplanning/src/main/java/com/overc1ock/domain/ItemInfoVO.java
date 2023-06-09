package com.overc1ock.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ItemInfoVO {
	
	private String item_code;
	private String item_name;
	private String sc_code;
	private String sc_name;
	private String mc_code;
	private String mc_name;
	private String standard;
	private String material;
	private String specification_file;
	private String draw_file;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date item_registration_date;
	
}
