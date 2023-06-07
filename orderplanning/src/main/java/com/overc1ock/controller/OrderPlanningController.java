package com.overc1ock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.overc1ock.service.OrderPlanningService;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/orderplanning/*")
public class OrderPlanningController {
	
	OrderPlanningService opservice;
	
	@GetMapping("/itemInfo")
	public void itemInfo(Model model) {
		log.info("품목 정보 등록 페이지 요청");
		model.addAttribute("getItemInfo", opservice.getItemInfo());
	}
	
	@GetMapping("/contract")
	public void contract(Model model) {
		log.info("계약 등록 페이지 요청");
		model.addAttribute("getContract", opservice.getContract());
	}
	
	@GetMapping("/procurementPlan")
	public void procurementPlan(Model model) {
		log.info("조달 계획 등록 페이지 요청");
		model.addAttribute("getProcurementPlan", opservice.getProcurementPlan());
	}

}
