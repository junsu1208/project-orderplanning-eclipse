package com.overc1ock.service;

import java.util.List;

import com.overc1ock.domain.ContractVO;

public interface ContractService {
	
	// 계약 등록
	List<ContractVO> getContract(); // 목록 가져오기
	List<ContractVO> getItemCodeForContract(); // 품목 코드 가져오기
	ContractVO getItemInfoForContract(Integer item_code); // 품목 코드로 선택된 품목 정보 가져오기 
	List<ContractVO> getSubcontractorName(); // 협력 업체명 가져오기
	ContractVO getSubcontractor(String subcontractor_name); // 협력 업체명으로 선택된 협력 업체 정보 가져오기
	void registerContract(ContractVO vo); // 등록
	ContractVO inquiryContract(Integer contract_code); // 조회
	Integer deleteContract(Integer contract_code); // 삭제
	boolean modifyContract(ContractVO vo); // 수정

}
