package com.overc1ock.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.overc1ock.domain.ContractVO;
import com.overc1ock.domain.ItemInfoVO;
import com.overc1ock.service.ContractService;
import com.overc1ock.service.ItemInfoService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("orderplanning/api/*")
@Log4j
@AllArgsConstructor
public class APIController {
	
	ItemInfoService iservice;
	ContractService cservice;
	private HttpServletRequest request;
	
	@GetMapping("/getsubcategory")
	public List<ItemInfoVO> getSubCategory(Integer mc_code) {
		return iservice.getSubCategory(mc_code);
	}
	
	@GetMapping("/getiteminfoforcontract")
	public ContractVO getItemInfoForContract(String item_code) {
		return cservice.getItemInfoForContract(item_code);
	}
	
	@GetMapping("/getsubcontractor")
	public ContractVO getSubcontractor(String subcontractor_name) {
		return cservice.getSubcontractor(subcontractor_name);
	}
	
	@GetMapping("/inquirycontract")
	public ContractVO inquiryContract(Integer contract_code) {
		ContractVO vo = cservice.inquiryContract(contract_code);
		String contractFile = vo.getContract_file();
		log.info(contractFile);
		contractFile = contractFile.replace("\\", "/");
		log.info(contractFile);
		vo.setContract_file(contractFile);
		return vo;
	}
	
	@GetMapping("/display")
	public ResponseEntity<byte[]> displayImage(String fileName) {
		File file = new File(request.getServletContext().getRealPath("") + fileName);
		ResponseEntity<byte[]> result = null;
		try {
			HttpHeaders header =  new HttpHeaders();
			MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap();
			header.add("Content-Type", mimeTypesMap.getContentType(file));
			log.info("파일 경로: " + file.toPath() + "콘텐츠 타입: " + Files.probeContentType(file.toPath()));
			result = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			log.info("파일을 byte로 변환하는 도중 오류 발생");
		}
		return result;
	}
	
}
