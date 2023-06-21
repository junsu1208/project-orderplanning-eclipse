package com.overc1ock.mapper;

import java.util.List;

import com.overc1ock.domain.ContractVO;
import com.overc1ock.domain.ItemInfoVO;
import com.overc1ock.domain.ProcurementPlanVO;

public interface OrderPlanningMapper {
	
	// 품목 정보 목록
	List<ItemInfoVO> getItemInfo(); // 목록 가져오기
	List<ItemInfoVO> getSubCategoryCode(); // 중분류 코드 가져오기
	Integer registerItemInfo(ItemInfoVO vo); // 등록
	ItemInfoVO inquiryItemInfo(String item_code); // 조회
	Integer deleteItemInfo(String item_code); // 삭제
	Integer modifyItemInfo(ItemInfoVO vo); // 수정
	
	// 계약 등록
	List<ContractVO> getContract(); // 목록 가져오기
	List<ContractVO> getItemCodeForContract(); // 품목 코드 가져오기
	List<ContractVO> getSubcontractorName(); // 협력 업체명 가져오기
	int registerContract(ContractVO vo); // 등록
	ContractVO inquiryContract(Integer contract_code); // 조회
	int deleteContract(Integer contract_code); // 삭제
	int modifyContract(ContractVO vo); // 수정
	
	// 조달 계획 등록
	List<ProcurementPlanVO> getProcurementPlan(); // 목록 가져오기
	List<ProcurementPlanVO> getItemCodeForProcurementPlan(); // 품목 코드 가져오기
	int registerProcurementPlan(ProcurementPlanVO vo); // 등록
	ProcurementPlanVO inquiryProcurementPlan(Integer pp_code); // 조회
	int deleteProcurementPlan(Integer pp_code); // 삭제
	int modifyProcurementPlan(ProcurementPlanVO vo); // 수정
	
}
