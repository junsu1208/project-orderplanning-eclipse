package com.overc1ock.domain;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class SubcontractorVO {
	
	private String subcontractor_name;
	private String subcontractor_person;
	private String subcontractor_tel;
	private String subcontractor_email;
	private String subcontractor_address;
	private String subcontractor_date;
	
	public String getSubcontractorDate() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		if (subcontractor_date == null) {
			return null;
		}
		return simpleDateFormat.format(subcontractor_date);
	}

}
