package com.overc1ock.service;

import java.util.List;

import com.overc1ock.domain.ContractVO;

public interface ContractService {
	
	// 계약 등록
	List<ContractVO> getContract(); // 목록 가져오기
	List<ContractVO> getItemCodeForContract(); // 품목 코드 가져오기
	List<ContractVO> getSubcontractorName(); // 협력 업체명 가져오기
	void registerContract(ContractVO vo); // 등록
	ContractVO inquiryContract(Long contract_code); // 조회
	boolean deleteContract(Long contract_code); // 삭제
	boolean modifyContract(ContractVO vo); // 수정

}
