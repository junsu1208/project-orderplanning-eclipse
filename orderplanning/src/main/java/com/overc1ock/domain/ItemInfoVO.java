package com.overc1ock.domain;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ItemInfoVO {
	
	private Long item_code;
	private String item_name;
	private String standard;
	private String material;
	private String specification_file;
	private String draw_file;
	private Date item_registration_date;
	private Integer sc_code;
	
}
