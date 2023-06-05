package com.overc1ock.domain;

import lombok.Data;

@Data
public class ItemInfoVO {
	
	private Long item_code;
	private String item_name;
	private String standard;
	private String material;
	private String specification_file;
	private String draw_file;
	private String mc_name;
	private String sc_name;

}
