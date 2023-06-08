package com.overc1ock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.overc1ock.service.ContractService;
import com.overc1ock.service.ItemInfoService;
import com.overc1ock.service.ProcurementPlanService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/orderplanning/*")
@AllArgsConstructor
public class OrderPlanningController {
	
	ItemInfoService itemInfoService;

	@GetMapping("/itemInfo")
	public void itemInfo(Model model) {
		log.info("품목 정보 등록 페이지 요청");
		model.addAttribute("itemInfo", itemInfoService.getItemInfo());
	}
	
	@GetMapping("/contract")
	public void contract() {
		log.info("계약 등록 페이지 요청");
	}
	
	@GetMapping("/procurementPlan")
	public void procurementPlan() {
		log.info("조달 계획 등록 페이지 요청");
	}

}
