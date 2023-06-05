package com.overc1ock.mapper;

import java.util.List;

import com.overc1ock.domain.ContractVO;
import com.overc1ock.domain.Criteria;
import com.overc1ock.domain.ItemInfoVO;
import com.overc1ock.domain.ProcurementPlanVO;

public interface OrderPlanningMapper {
	
	// 품목 정보 목록 가져오기
	List<ItemInfoVO> getItemInfo();
	
	// 품목 정보 목록 가져오기(페이징 처리)
	List<ItemInfoVO> getItemInfoWithPaging(Criteria cri);
	
	// 품목 정보 저장
	int saveItemInfo(ItemInfoVO vo);
	
	// 품목 정보 조회
	ItemInfoVO inquiryItemInfo(Long item_code);
	
	// 품목 정보 삭제
	int deleteItemInfo(Long item_code);
	
	// 품목 정보 수정
	int modifyItemInfo(ItemInfoVO vo);
	
	// 품목 정보(계약) 가져오기
	List<ContractVO> getContact();
	
	// 품목 정보(계약) 가져오기(페이징 처리)
	List<ContractVO> getContactWithPaging(Criteria cri);
	
	// 계약 조회
	ContractVO inquiryContract(Long contract_code);
	
	// 계약 등록
	int registerContract(ContractVO vo);
	
	// 계약 삭제
	int deleteContract(Long contract_code);
	
	// 계약 수정
	int modifyContract(ContractVO vo);
	
	// 조달 예정 품목 목록 가져오기
	List<ProcurementPlanVO> getProcurementPlan();
	
	// 품목 정보(계약) 가져오기(페이징 처리)
	List<ProcurementPlanVO> getProcurementPlanWithPaging(Criteria cri);
	
	// 조달 계획 조회
	ProcurementPlanVO inquiryProcurementPlan(Long pp_code);
	
	// 조달 계획 등록
	int registerProcurementPlan(ProcurementPlanVO vo);
	
	// 조달 계획 삭제
	int deleteProcurementPlan(Long pp_code);
	
	// 조달 계획 수정
	int modifyProcurementPlan(ProcurementPlanVO vo);
	
}
