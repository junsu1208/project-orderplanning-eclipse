package com.overc1ock.mapper;

import java.util.List;

import com.overc1ock.domain.ContractVO;
import com.overc1ock.domain.Criteria;
import com.overc1ock.domain.ItemInfoVO;
import com.overc1ock.domain.ProcurementPlanVO;

public interface OrderPlanningMapper {
	
	// 품목 정보 목록
	List<ItemInfoVO> getItemInfo(); // 목록 가져오기
	List<ItemInfoVO> getItemInfoWithPaging(Criteria cri); // 페이징 처리
	int saveItemInfo(ItemInfoVO vo); // 저장
	ItemInfoVO inquiryItemInfo(Long item_code); // 조회
	int deleteItemInfo(Long item_code); // 삭제
	int modifyItemInfo(Long item_code); // 수정
	
	// 계약 등록
	List<ContractVO> getContract(); // 목록 가져오기
	List<ContractVO> getContractWithPaging(Criteria cri); // 페이징 처리
	ContractVO inquiryContract(Long contract_code); // 조회
	int registerContract(ContractVO vo); // 등록
	int deleteContract(Long contract_code); // 삭제
	int modifyContract(ContractVO vo); // 수정
	
	// 조달 계획 등록
	List<ProcurementPlanVO> getProcurementPlan(); // 목록 가져오기
	List<ProcurementPlanVO> getProcurementPlanWithPaging(Criteria cri); // 페이징 처리
	ProcurementPlanVO inquiryProcurementPlan(Long pp_code); // 조회
	int registerProcurementPlan(ProcurementPlanVO vo); // 등록
	int deleteProcurementPlan(Long pp_code); // 삭제
	int modifyProcurementPlan(ProcurementPlanVO vo); // 수정
	
}
