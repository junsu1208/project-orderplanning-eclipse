package com.overc1ock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.overc1ock.domain.SubcontractorVO;
import com.overc1ock.service.SubcontractorService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/registerinfo/*")
@AllArgsConstructor
public class RegisterInfoController {
	
	SubcontractorService subcontractorService;
	
	@GetMapping("/subcontractor")
	public void subcontractor(Model model) {
		log.info("협력 업체 등록 페이지 요청");
		model.addAttribute("subcontractor", subcontractorService.getSubcontractor());
	}
	
	@PostMapping("/registerSubcontractor")
	public String registerSubcontractor(SubcontractorVO vo) {
		log.info("협력 업체 등록 기능 요청");
		subcontractorService.registerSubcontractor(vo);
		return "redirect:/registerinfo/subcontractor";
	}
	
	@GetMapping("/productionplan")
	public void productionPlan() {
		log.info("생산 계획 등록 페이지 요청");
	}
	
}
