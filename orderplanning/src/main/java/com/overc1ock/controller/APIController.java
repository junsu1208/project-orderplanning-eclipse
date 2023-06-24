package com.overc1ock.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.overc1ock.domain.ContractVO;
import com.overc1ock.service.ContractService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("orderplanning/api/*")
@Log4j
@AllArgsConstructor
public class APIController {
	
	ContractService cservice;
	
	@GetMapping("/getiteminfoforcontract")
	public ContractVO getItemInfoForContract(Integer item_code) {
		return cservice.getItemInfoForContract(item_code);
	}
	
	@GetMapping("/getsubcontractor")
	public ContractVO getSubcontractor(String subcontractor_name) {
		return cservice.getSubcontractor(subcontractor_name);
	}


}
