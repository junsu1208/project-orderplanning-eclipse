package com.overc1ock.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	private HttpServletRequest request;

	@GetMapping("/iteminfo")
	public void itemInfo(Model model) {
		log.info("품목 정보 등록 페이지 요청");
		model.addAttribute("itemInfo", itemInfoService.getItemInfo());
		model.addAttribute("getMajorCategory", itemInfoService.getMajorCategory());
	}

	@PostMapping("/registeriteminfo")
	public String registerItemInfo(ItemInfoVO vo, MultipartFile specificationFile, MultipartFile drawFile, RedirectAttributes rttr) {
		log.info("품목 정보 등록 기능 요청");
		log.info("사양 파일: " + specificationFile);
		log.info("도면 파일: " + drawFile);
		log.info("vo " + vo);
		String uploadSFolder = "C:/usr/uploadFile/resources/specification_file"; // 제작 사양 파일 저장 경로 (개발용)
//		String uploadSFolder = "/usr/uploadFile/resources/specification_file"; // 제작 사양 파일 저장 경로 (운영용)
		// 제작 사양 파일 저장 폴더 생성
		File uploadSPath = new File(uploadSFolder);
		if (uploadSPath.exists() == false) {
			uploadSPath.mkdirs();
		}
		String uploadDFolder = "C:/usr/uploadFile/resources/draw_file"; // 도면 파일 저장 경로 (개발용)
//		String uploadDFolder = "/usr/uploadFile/resources/draw_file"; // 도면 파일 저장 경로 (운영용)
		// 도면 파일 저장 폴더 생성
		File uploadDPath = new File(uploadDFolder);
		if (uploadDPath.exists() == false) {
			uploadDPath.mkdirs();
		}
		// 제작 사양 파일 저장
		log.info("--------------------------------------------------");
		log.info("업로드할 제작 사양 파일 이름: " + specificationFile.getOriginalFilename());
		log.info("제작 사양 파일 크기: " + specificationFile.getSize());
		UUID uuid = UUID.randomUUID();
		String uploadSFileName = uuid.toString() + "_" + specificationFile.getOriginalFilename();
		File saveSpecificationFile = new File(uploadSPath, uploadSFileName);
		try {
			specificationFile.transferTo(saveSpecificationFile);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		// 도면 파일 저장
		log.info("--------------------------------------------------");
		log.info("업로드할 도면 파일 이름: " + drawFile.getOriginalFilename());
		log.info("도면 파일 크기: " + drawFile.getSize());
		String uploadDFileName = uuid.toString() + "_" + drawFile.getOriginalFilename();
		File saveDrawFile = new File(uploadDPath, uploadDFileName);
		try {
			drawFile.transferTo(saveDrawFile);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		vo.setSpecification_file("/resources/specification_file/" + uploadSFileName);
		vo.setDraw_file("/resources/draw_file/" + uploadDFileName);	
		rttr.addFlashAttribute("registerResult", itemInfoService.registerItemInfo(vo));
		return "redirect:/orderplanning/iteminfo";
	}

	@PostMapping("/deleteiteminfo")
	public String deleteItemInfo(String item_code, RedirectAttributes rttr) {
		log.info("품목 정보 삭제 기능 요청");
		try {
			rttr.addFlashAttribute("deleteResult", itemInfoService.deleteItemInfo(item_code));
		} catch (DataIntegrityViolationException e) {
			log.info("품목 정보 삭제 도중 오류 발생");
			e.printStackTrace();
			rttr.addFlashAttribute("deleteResult", -1);
		}
		return "redirect:/orderplanning/iteminfo";
	}

	@PostMapping("/modifyiteminfo")
	public String modifyItemInfo(ItemInfoVO vo, MultipartFile specificationFile, MultipartFile drawFile, RedirectAttributes rttr) {
		log.info("품목 정보 수정 기능 요청");
		String uploadSFolder = "C:/usr/uploadFile/resources/specification_file"; // 제작 사양 파일 저장 경로 >> 개발용
//		String uploadSFolder = "/usr/uploadFile/resources/specification_file"; // 제작 사양 파일 저장 경로 >> 운영용
		// 사양 파일 저장 폴더 생성
		File uploadSPath = new File(uploadSFolder);
		if (uploadSPath.exists() == false) {
			uploadSPath.mkdirs();
		}
		String uploadDFolder = "C:/usr/uploadFile/resources/draw_file"; // 도면 파일 저장 경로 (개발용)
//		String uploadDFolder = "/usr/uploadFile/resources/draw_file"; // 도면 파일 저장 경로 (운영용)
		// 도면 파일 저장 폴더 생성
		File uploadDPath = new File(uploadDFolder);
		if (uploadDPath.exists() == false) {
			uploadDPath.mkdirs();
		}
		// 제작 사양 파일 저장
		log.info("--------------------------------------------------");
		log.info("업로드할 제작 사양 파일 이름: " + specificationFile.getOriginalFilename());
		log.info("제작 사양 파일 크기: " + specificationFile.getSize());
		UUID uuid = UUID.randomUUID();
		String uploadSFileName = uuid.toString() + "_" + specificationFile.getOriginalFilename();
		File saveSpecificationFile = new File(uploadSPath, uploadSFileName);
		try {
			specificationFile.transferTo(saveSpecificationFile);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		// 도면 파일 저장
		log.info("--------------------------------------------------");
		log.info("업로드할 도면 파일 이름: " + drawFile.getOriginalFilename());
		log.info("도면 파일 크기: " + drawFile.getSize());
		String uploadDFileName = uuid.toString() + "_" + drawFile.getOriginalFilename();
		File saveDrawFile = new File(uploadDPath, uploadDFileName);
		try {
			drawFile.transferTo(saveDrawFile);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		vo.setSpecification_file("/resources/specification_file/" + uploadSFileName);
		vo.setDraw_file("/resources/draw_file/" + uploadDFileName);
		rttr.addFlashAttribute("modifyResult", itemInfoService.modifyItemInfo(vo));
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
	public String registerContract(ContractVO vo, MultipartFile contract_imagefile, RedirectAttributes rttr) {
		log.info("계약 등록 기능 요청");
		String uploadFolder = "C:/usr/uploadFile/resources/contract_file"; // 계약서 파일 저장 경로 (개발용)
//		String uploadFolder = "/usr/uploadFile/resources/contract_file"; // 계약서 파일 저장 경로 (운영용)
		
		// 계약서 파일 저장 폴더 생성
		File uploadPath = new File(uploadFolder);
		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		// 계약서 파일 저장
		log.info("--------------------------------------------------");
		log.info("업로드할 계약서 파일 이름: " + contract_imagefile.getOriginalFilename());
		log.info("계약서 파일 크기: " + contract_imagefile.getSize());
		UUID uuid = UUID.randomUUID();
		String uploadFileName = uuid.toString() + "_" + contract_imagefile.getOriginalFilename();
		File saveContractFile = new File(uploadPath, uploadFileName);
		try {
			contract_imagefile.transferTo(saveContractFile);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		vo.setContract_file("/resources/contract_file/" + uploadFileName);
		contractService.registerContract(vo);
		rttr.addFlashAttribute("cvo", vo);
		return "redirect:/orderplanning/contract";
	}

	@PostMapping("/deletecontract")
	public String deleteContract(Integer contract_code, RedirectAttributes rttr) {
		log.info("계약 삭제 기능 요청");
		try {
			rttr.addFlashAttribute("deleteres", contractService.deleteContract(contract_code));	
		} catch (DataIntegrityViolationException e) {
			log.info("계약 삭제 도중 오류 발생");
			e.printStackTrace();
			rttr.addFlashAttribute("deleteres", -1);
		}
		return "redirect:/orderplanning/contract";
	}

	@PostMapping("/modifycontract")
	public String modifyContract(ContractVO vo, MultipartFile contract_imagefile, RedirectAttributes rttr) {
		log.info("계약 수정 기능 요청");
		String uploadFolder = "C:/usr/uploadFile/resources/contract_file"; // 계약서 파일 저장 경로 (개발용)
//		String uploadFolder = "/usr/uploadFile/resources/contract_file"; // 계약서 파일 저장 경로 (운영용)
		// 계약서 파일 저장 폴더 생성
		File uploadPath = new File(uploadFolder);
		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		if (!contract_imagefile.isEmpty()) {
			// 계약서 파일 저장
			log.info("--------------------------------------------------");
			log.info("업로드할 계약서 파일 이름: " + contract_imagefile.getOriginalFilename());
			log.info("계약서 파일 크기: " + contract_imagefile.getSize());
			UUID uuid = UUID.randomUUID();
			String uploadFileName = uuid.toString() + "_" + contract_imagefile.getOriginalFilename();
			File saveContractFile = new File(uploadPath, uploadFileName);
			try {
				contract_imagefile.transferTo(saveContractFile);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
			vo.setContract_file("/resources/contract_file/"+uploadFileName);
		}
		rttr.addFlashAttribute("modifyres", contractService.modifyContract(vo));
		rttr.addFlashAttribute("modifyvo", vo);
		return "redirect:/orderplanning/contract";
	}

	@GetMapping("/procurementplan")
	public void procurementPlan(Model model, Criteria cri) {
		log.info("조달 계획 등록 페이지 요청");
		model.addAttribute("ppList", procurementPlanService.getProcurementPlan(cri));
		model.addAttribute("cri", cri);
	}

	@PostMapping("/registerprocurementplan")
	public String registerProcurementPlan(ProcurementPlanVO procurementPlanVO, RedirectAttributes rttr) {
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
			rttr.addFlashAttribute("registerResult", procurementPlanService.registerProcurementPlan(list));
		}
		return "redirect:/orderplanning/procurementplan";
	}
	
	@PostMapping("/deleteprocurementplan")
	public String deleteProcurementPlan(Integer pp_code, RedirectAttributes rttr) {
		log.info("조달 계획 삭제 요청");
		try {
			rttr.addFlashAttribute("deleteResult", procurementPlanService.deleteProcurementPlan(pp_code));	
		} catch (DataIntegrityViolationException e) {
			log.info("조달 계획 삭제 도중 오류 발생");
			e.printStackTrace();
			rttr.addFlashAttribute("deleteResult", -1);
		}
		return "redirect:/orderplanning/procurementplan";
	}
	
	@PostMapping("/updateprocurementplan")
	public String updateProcurementPlan(ProcurementPlanVO vo, RedirectAttributes rttr) {
		log.info("조달 계획 수정 요청");
		rttr.addFlashAttribute("modifyResult", procurementPlanService.modifyProcurementPlan(vo));
		return "redirect:/orderplanning/procurementplan";
	}
	
}
