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
	
	@GetMapping("/inquiryiteminfo")
	public ItemInfoVO inquiryItemInfo(String item_code) {
		return iservice.inquiryItemInfo(item_code);
	}
	
	@GetMapping("/inquirycontract")
	public ContractVO inquiryContract(Integer contract_code) {
		return cservice.inquiryContract(contract_code);
	}
	
	@GetMapping("/display")
	public ResponseEntity<byte[]> displayImage(String fileName) {
		File file = new File("C:/usr/uploadFile" + fileName); // 파일 불러오기 >> 개발용
//		File file = new File("/usr/uploadFile" + fileName); // 파일 불러오기 >> 운영용
		ResponseEntity<byte[]> result = null;
		try {
			HttpHeaders header =  new HttpHeaders();
			MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap();
//			header.add("Content-Type", mimeTypesMap.getContentType(file));
			header.add("Content-Type", Files.probeContentType(file.toPath()));
			log.info("파일 경로: " + file.toPath());
			log.info("콘텐츠 타입 Files.probeContentType: " + Files.probeContentType(file.toPath()));
			log.info("콘텐츠 타입 mimeTypesMap.getContentType:" + mimeTypesMap.getContentType(file));
			result = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
		} catch (IOException e) {
			e.printStackTrace();
			log.info("파일을 바이트로 변환하는 도중 오류 발생");
		}
		return result;
	}
	
}
