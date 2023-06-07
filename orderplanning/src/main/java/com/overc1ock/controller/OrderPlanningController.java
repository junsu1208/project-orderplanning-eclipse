package com.overc1ock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/orderplanning/*")
public class OrderPlanningController {

	@GetMapping("/itemInfo")
	public void itemInfo() {
		log.info("품목 정보 등록 페이지 요청");
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
