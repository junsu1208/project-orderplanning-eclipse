package com.overc1ock.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.overc1ock.domain.ContractVO;
import com.overc1ock.mapper.OrderPlanningMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class ContractServiceImpl implements ContractService {
	
	OrderPlanningMapper mapper;
	
	@Override
	public List<ContractVO> getContract() {
		log.info("계약 품목 정보 목록 요청");
		return mapper.getContract();
	}
	
	@Override
	public List<ContractVO> getItemCodeForContract() {
		return mapper.getItemCodeForContract();
	}
	
	@Override
	public ContractVO getItemInfoForContract(String item_code) {
		return mapper.getItemInfoForContract(item_code);
	}

	
	@Override
	public List<ContractVO> getSubcontractorName() {
		return mapper.getSubcontractorName();
	}
	
	@Override
	public ContractVO getSubcontractor(String subcontractor_name) {
		return mapper.getSubcontractor(subcontractor_name);
	}
	
	@Override
	public Integer registerContract(ContractVO vo) {
		log.info("계약 등록 요청, 변수값: " + vo);
		return mapper.registerContract(vo);
	}
	
	@Override
	public ContractVO inquiryContract(Integer contract_code) {
		log.info("계약 조회 요청, 변수값: " + contract_code);
		return mapper.inquiryContract(contract_code);
	}
	
	@Override
	public Integer deleteContract(Integer contract_code) {
		log.info("계약 삭제 요청, 변수값: " + contract_code);
		return mapper.deleteContract(contract_code);
	}

	@Override
	public Integer modifyContract(ContractVO vo) {
		log.info("계약 수정 요청, 변수값: " + vo);
		return mapper.modifyContract(vo);
	}

}
