package com.overc1ock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.overc1ock.domain.ContractVO;
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
	
	@PostMapping("/registerItemInfo")
	public String registerItemInfo(ItemInfoVO vo) {
		log.info("품목 정보 등록 기능 요청");
		itemInfoService.registerItemInfo(vo);
		return "redirect:/orderplanning/itemInfo";
	}
	
	@PostMapping("/inquiryItemInfo")
	public String inquiryItemInfo(Long item_code, Model model) {
		log.info("품목 정보 조회 기능 요청");
		model.addAttribute(itemInfoService.inquiryItemInfo(item_code));
		return "redirect:/orderplanning/itemInfo";
	}
	
	@PostMapping("/deleteItemInfo")
	public String deleteItemInfo(Long item_code) {
		log.info("품목 정보 삭제 기능 요청");
		itemInfoService.deleteItemInfo(item_code);
		return "redirect:/orderplanning/itemInfo";
	}
	
	@PostMapping("/modifyItemInfo")
	public String modifyItemInfo(ItemInfoVO vo) {
		log.info("품목 정보 수정 기능 요청");
		itemInfoService.modifyItemInfo(vo);
		return "redirect:/orderplanning/itemInfo";
	}
	
	@GetMapping("/contract")
	public void contract(Model model) {
		log.info("계약 등록 페이지 요청");
		model.addAttribute("contract", contractService.getContract());
		model.addAttribute("getSubcontractor", contractService.getSubcontractor());
		model.addAttribute("getItemInfoForContract", contractService.getItemInfoForContract());
	}
	
	@PostMapping("/registerContract")
	public String registerContract(ContractVO vo) {
		log.info("계약 등록 기능 요청");
		contractService.registerContract(vo);
		return "redirect:/orderplanning/contract";
	}
	
	@PostMapping("/inquiryContract")
	public String inquiryContract(Long contract_code, Model model) {
		log.info("계약 조회 기능 요청");
		contractService.inquiryContract(contract_code);
		return "redirect:/orderplanning/contract";
	}
	
	@PostMapping("/deleteContract")
	public String deleteContract(Long contract_code) {
		log.info("계약 삭제 기능 요청");
		contractService.deleteContract(contract_code);
		return "redirect:/orderplanning/contract";
	}
	
	@PostMapping("/modifyContract")
	public String modifyContract(ContractVO vo) {
		log.info("계약 수정 기능 요청");
		contractService.modifyContract(vo);
		return "redirect:/orderplanning/contract";
	}
	
	@GetMapping("/procurementPlan")
	public void procurementPlan(Model model) {
		log.info("조달 계획 등록 페이지 요청");
		model.addAttribute("procurementPlan", procurementPlanService.getProcurementPlan());
		model.addAttribute("getItemInfoForProcurementPlan", 
				procurementPlanService.getItemInfoForProcurementPlan());
	}

}
