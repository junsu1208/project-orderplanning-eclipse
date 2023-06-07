package com.overc1ock.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.overc1ock.domain.ContractVO;
import com.overc1ock.domain.ItemInfoVO;
import com.overc1ock.domain.ProcurementPlanVO;
import com.overc1ock.mapper.OrderPlanningMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class OrderPlanningServiceImpl implements OrderPlanningService {
	
	OrderPlanningMapper mapper;
	
	@Override
	public List<ItemInfoVO> getItemInfo() {
		log.info("품목 정보 목록 요청");
		return mapper.getItemInfo();
	}

	@Override
	public void saveItemInfo(ItemInfoVO vo) {
		log.info("품목 정보 저장 요청, 변수값: " + vo);
		mapper.saveItemInfo(vo);
	}

	@Override
	public ItemInfoVO inquiryItemInfo(Long item_code) {
		log.info("품목 정보 조회 요청, 변수값: " + item_code);
		return mapper.inquiryItemInfo(item_code);
	}

	@Override
	public boolean deleteItemInfo(Long item_code) {
		log.info("품목 정보 삭제 요청, 변수값: " + item_code);
		return mapper.deleteItemInfo(item_code) == 1;
	}

	@Override
	public boolean modifyItemInfo(ItemInfoVO vo) {
		log.info("품목 정보 수정 요청, 변수값: " + vo);
		return mapper.modifyItemInfo(vo) == 1;
	}

	@Override
	public List<ContractVO> getContract() {
		log.info("계약 품목 정보 목록 요청");
		return mapper.getContact();
	}

	@Override
	public ContractVO inquiryContract(Long contract_code) {
		log.info("계약 조회 요청, 변수값: " + contract_code);
		return mapper.inquiryContract(contract_code);
	}

	@Override
	public void registerContract(ContractVO vo) {
		log.info("계약 등록 요청, 변수값: " + vo);
		mapper.registerContract(vo);
	}

	@Override
	public boolean deleteContract(Long contract_code) {
		log.info("계약 삭제 요청, 변수값: " + contract_code);
		return mapper.deleteContract(contract_code) == 1;
	}

	@Override
	public boolean modifyContract(ContractVO vo) {
		log.info("계약 수정 요청, 변수값: " + vo);
		return mapper.modifyContract(vo) == 1;
	}

	@Override
	public List<ProcurementPlanVO> getProcurementPlan() {
		log.info("조달 예정 품목 목록 요청");
		return mapper.getProcurementPlan();
	}

	@Override
	public ProcurementPlanVO inquiryProcurementPlan(Long pp_code) {
		log.info("조달 계획 조회 요청, 변수값: " + pp_code);
		return mapper.inquiryProcurementPlan(pp_code);
	}

	@Override
	public void registerProcurementPlan(ProcurementPlanVO vo) {
		log.info("조달 계획 등록 요청, 변수값: " + vo);
		mapper.registerProcurementPlan(vo);
	}

	@Override
	public boolean deleteProcurementPlan(Long pp_code) {
		log.info("조달 계획 삭제 요청, 변수값: " + pp_code);
		return mapper.deleteProcurementPlan(pp_code) == 1;
	}

	@Override
	public boolean modifyProcurementPlan(ProcurementPlanVO vo) {
		log.info("조달 계획 수정 요청, 변수값: " + vo);
		return mapper.modifyProcurementPlan(vo) == 1;
	}

}
