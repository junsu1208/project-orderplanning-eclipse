package com.overc1ock.domain;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ItemUsePlanVO {
	
	Integer iup_code;
	String product_name;
	String item_name;
	Integer consumption;
	Date iup_date;
	Integer ppp_code;
	String item_code;
	
}
