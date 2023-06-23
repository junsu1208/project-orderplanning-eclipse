package com.overc1ock.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.overc1ock.domain.ContractVO;
import com.overc1ock.domain.Criteria;
import com.overc1ock.domain.ItemInfoVO;
import com.overc1ock.domain.ProcurementPlanVO;
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

	@GetMapping("/iteminfo")
	public void itemInfo(Model model) {
		log.info("품목 정보 등록 페이지 요청");
		model.addAttribute("itemInfo", itemInfoService.getItemInfo());
		model.addAttribute("getMajorCategory", itemInfoService.getMajorCategory());
		model.addAttribute("getSubCategory", itemInfoService.getSubCategory());
	}
	
	@PostMapping("/registeriteminfo")
	public String registerItemInfo(ItemInfoVO vo, 
			MultipartFile[] specification_file, MultipartFile[] draw_file) {
		log.info("품목 정보 등록 기능 요청");
		String uploadSpecificationFile = "C:/orderplanning/specification_file"; // 제작 사양 파일 업로드
		String uploadDrawFile = "C:/orderplanning/draw_file"; // 도면 파일 업로드
		// 제작 사양 파일 저장
		for (MultipartFile multipartFile : specification_file) {
			log.info("--------------------------------------------------");
			log.info("업로드된 제작 사양 파일 이름: " + multipartFile.getOriginalFilename());
			log.info("제작 사양 파일 크기: " + multipartFile.getSize());
			File saveSpecificationFile = new File(uploadSpecificationFile, 
					multipartFile.getOriginalFilename());
			try {
				multipartFile.transferTo(saveSpecificationFile);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
		// 도면 파일 저장
		for (MultipartFile multipartFile : draw_file) {
			log.info("--------------------------------------------------");
			log.info("업로드된 도면 파일 이름: " + multipartFile.getOriginalFilename());
			log.info("도면 파일 크기: " + multipartFile.getSize());
			File saveDrawFile = new File(uploadDrawFile, 
					multipartFile.getOriginalFilename());
			try {
				multipartFile.transferTo(saveDrawFile);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
		itemInfoService.registerItemInfo(vo);
		return "redirect:/orderplanning/iteminfo";
	}
	
	@PostMapping("/inquiryiteminfo")
	public String inquiryItemInfo(String item_code, Model model) {
		log.info("품목 정보 조회 기능 요청");
		model.addAttribute(itemInfoService.inquiryItemInfo(item_code));
		return "redirect:/orderplanning/iteminfo";
	}
	
	@PostMapping("/deleteiteminfo")
	public String deleteItemInfo(String item_code) {
		log.info("품목 정보 삭제 기능 요청");
		itemInfoService.deleteItemInfo(item_code);
		return "redirect:/orderplanning/iteminfo";
	}
	
	@PostMapping("/modifyiteminfo")
	public String modifyItemInfo(ItemInfoVO vo,
			MultipartFile[] specification_file, MultipartFile[] draw_file) {
		log.info("품목 정보 수정 기능 요청");
		String uploadSpecificationFile = "C:/orderplanning/specification_file"; // 제작 사양 파일 업로드
		String uploadDrawFile = "C:/orderplanning/draw_file"; // 도면 파일 업로드
		// 제작 사양 파일 저장
		for (MultipartFile multipartFile : specification_file) {
			log.info("--------------------------------------------------");
			log.info("업로드된 제작 사양 파일 이름: " + multipartFile.getOriginalFilename());
			log.info("제작 사양 파일 크기: " + multipartFile.getSize());
			File saveSpecificationFile = new File(uploadSpecificationFile, 
					multipartFile.getOriginalFilename());
			try {
				multipartFile.transferTo(saveSpecificationFile);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
		// 도면 파일 저장
		for (MultipartFile multipartFile : draw_file) {
			log.info("--------------------------------------------------");
			log.info("업로드된 도면 파일 이름: " + multipartFile.getOriginalFilename());
			log.info("도면 파일 크기: " + multipartFile.getSize());
			File saveDrawFile = new File(uploadDrawFile, 
					multipartFile.getOriginalFilename());
			try {
				multipartFile.transferTo(saveDrawFile);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
		itemInfoService.modifyItemInfo(vo);
		return "redirect:/orderplanning/iteminfo";
	}
	
	@GetMapping("/contract")
	public void contract(Model model) {
		log.info("계약 등록 페이지 요청");
		model.addAttribute("contract", contractService.getContract());
		model.addAttribute("getItemCodeForContract", contractService.getItemCodeForContract());
		model.addAttribute("getSubcontractorName", contractService.getSubcontractorName());
	}
	
	@PostMapping("/registercontract")
	public String registerContract(ContractVO vo, MultipartFile[] contract_file) {
		log.info("계약 등록 기능 요청");
		String uploadContractFile = "C:/orderplanning/contract_file"; // 계약서 파일 업로드
		// 계약서 파일 저장
		for (MultipartFile multipartFile : contract_file) {
			log.info("--------------------------------------------------");
			log.info("업로드된 계약서 파일 이름: " + multipartFile.getOriginalFilename());
			log.info("계약서 파일 크기: " + multipartFile.getSize());
			File saveContractFile = new File(uploadContractFile, 
					multipartFile.getOriginalFilename());
			try {
				multipartFile.transferTo(saveContractFile);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
		contractService.registerContract(vo);
		return "redirect:/orderplanning/contract";
	}
	
	@PostMapping("/inquirycontract")
	public String inquiryContract(Integer contract_code, Model model) {
		log.info("계약 조회 기능 요청");
		contractService.inquiryContract(contract_code);
		return "redirect:/orderplanning/contract";
	}
	
	@PostMapping("/deletecontract")
	public String deleteContract(Integer contract_code) {
		log.info("계약 삭제 기능 요청");
		contractService.deleteContract(contract_code);
		return "redirect:/orderplanning/contract";
	}
	
	@PostMapping("/modifycontract")
	public String modifyContract(ContractVO vo, MultipartFile[] contract_file) {
		log.info("계약 수정 기능 요청");
		String uploadContractFile = "C:/orderplanning/contract_file"; // 계약서 파일 업로드
		// 계약서 파일 저장
		for (MultipartFile multipartFile : contract_file) {
			log.info("--------------------------------------------------");
			log.info("업로드된 계약서 파일 이름: " + multipartFile.getOriginalFilename());
			log.info("계약서 파일 크기: " + multipartFile.getSize());
			File saveContractFile = new File(uploadContractFile, 
					multipartFile.getOriginalFilename());
			try {
				multipartFile.transferTo(saveContractFile);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
		contractService.modifyContract(vo);
		return "redirect:/orderplanning/contract";
	}
	
	@GetMapping("/procurementplan")
	public void procurementPlan(Model model, Criteria cri) {
		log.info("조달 계획 등록 페이지 요청");
		model.addAttribute("ppList", procurementPlanService.getProcurementPlan(cri));
		model.addAttribute("cri", cri);
		
	}
	
	@PostMapping("/registerprocurementplan")
	public String registerProcurementPlan(ProcurementPlanVO procurementPlanVO, Criteria cri) {
		log.info("조달 계획 등록 작업 요청");
		List<ProcurementPlanVO> list = new ArrayList<ProcurementPlanVO>();
		for (ProcurementPlanVO vo : procurementPlanVO.getProcurementPlanVOList()) {
			if (vo.getProcurement_date() != null) {
				list.add(vo);
			}
		}
		log.info(list);
		if (list != null && !list.isEmpty()) {
			log.info("조달 계획 등록 수행 확인");
			procurementPlanService.registerProcurementPlan(list);
		}
		return "redirect:/orderplanning/procurementplan";
	}

}
