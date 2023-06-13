package com.overc1ock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.overc1ock.domain.ItemInfoVO;
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
	ContractService contractService;
	ProcurementPlanService procurementPlanService;

	@GetMapping("/itemInfo")
	public void itemInfo(Model model) {
		log.info("품목 정보 등록 페이지 요청");
		model.addAttribute("itemInfo", itemInfoService.getItemInfo());
		model.addAttribute("getSubCategory", itemInfoService.getSubCategory());
	}
	
	@PostMapping("/saveItemInfo")
	public String saveItemInfo(ItemInfoVO vo) {
		log.info("품목 정보 저장 기능 요청");
		itemInfoService.saveItemInfo(vo);
		return "redirect:/orderplanning/itemInfo";
	}
	
	@GetMapping("/contract")
	public void contract(Model model) {
		log.info("계약 등록 페이지 요청");
		model.addAttribute("contract", contractService.getContract());
		model.addAttribute("getSubcontractor", contractService.getSubcontractor());
		model.addAttribute("getItemInfoForContract", contractService.getItemInfoForContract());
	}
	
	@GetMapping("/procurementPlan")
	public void procurementPlan(Model model) {
		log.info("조달 계획 등록 페이지 요청");
		model.addAttribute("procurementPlan", procurementPlanService.getProcurementPlan());
		model.addAttribute("getItemInfoForProcurementPlan", 
				procurementPlanService.getItemInfoForProcurementPlan());
	}

}
