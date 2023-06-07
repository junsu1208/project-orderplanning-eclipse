package com.overc1ock.service;

import java.util.List;

import com.overc1ock.domain.ContractVO;
import com.overc1ock.domain.ItemInfoVO;
import com.overc1ock.domain.ProcurementPlanVO;

public interface OrderPlanningService {
	
	// 품목 정보 등록
	List<ItemInfoVO> getItemInfo(); // 목록 가져오기
	void saveItemInfo(ItemInfoVO vo); // 저장
	ItemInfoVO inquiryItemInfo(Long item_code); // 조회
	boolean deleteItemInfo(Long item_code); // 삭제
	boolean modifyItemInfo(ItemInfoVO vo); // 수정
	
	// 계약 등록
	List<ContractVO> getContract(); // 목록 가져오기
	ContractVO inquiryContract(Long contract_code); // 저장
	void registerContract(ContractVO vo); // 조회
	boolean deleteContract(Long contract_code); // 삭제
	boolean modifyContract(ContractVO vo); // 수정
	
	// 조달 계획 등록
	List<ProcurementPlanVO> getProcurementPlan(); // 목록 가져오기
	ProcurementPlanVO inquiryProcurementPlan(Long pp_code); // 저장
	void registerProcurementPlan(ProcurementPlanVO vo); // 조회
	boolean deleteProcurementPlan(Long pp_code); // 삭제
	boolean modifyProcurementPlan(ProcurementPlanVO vo); // 수정

}
