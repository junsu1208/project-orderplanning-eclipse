package com.overc1ock.domain;

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
	private String mc_name;
	private String sc_name;
	
	@Override
	public String toString() {
		return "ItemInfoVO [item_code=" + item_code + ", item_name=" + item_name + ", standard=" + standard
				+ ", material=" + material + ", specification_file=" + specification_file + ", draw_file=" + draw_file
				+ ", mc_name=" + mc_name + ", sc_name=" + sc_name + "]";
	}
	
}
