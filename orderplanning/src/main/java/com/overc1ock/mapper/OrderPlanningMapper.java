package com.overc1ock.mapper;

import java.util.List;

import com.overc1ock.domain.ContractVO;
import com.overc1ock.domain.Criteria;
import com.overc1ock.domain.ItemInfoVO;
import com.overc1ock.domain.ProcurementPlanVO;

public interface OrderPlanningMapper {
	
	// 품목 정보 목록
	List<ItemInfoVO> getItemInfo(); // 목록 가져오기
	List<ItemInfoVO> getMajorCategory(); // 대분류 가져오기
	List<ItemInfoVO> getSubCategory(Integer mc_code); // 중분류 가져오기
	Integer registerItemInfo(ItemInfoVO vo); // 등록
	ItemInfoVO inquiryItemInfo(String item_code); // 조회
	Integer deleteItemInfo(String item_code); // 삭제
	Integer modifyItemInfo(ItemInfoVO vo); // 수정
	
	// 계약 등록
	List<ContractVO> getContract(); // 목록 가져오기
	List<ContractVO> getItemCodeForContract(); // 품목 코드 가져오기
	ContractVO getItemInfoForContract(Integer item_code); // 품목 코드로 선택된 품목 정보 가져오기 
	List<ContractVO> getSubcontractorName(); // 협력 업체명 가져오기
	ContractVO getSubcontractor(String subcontractor_name); // 협력 업체명으로 선택된 협력 업체 정보 가져오기
	Integer registerContract(ContractVO vo); // 등록
	ContractVO inquiryContract(Integer contract_code); // 조회
	Integer deleteContract(Integer contract_code); // 삭제
	Integer modifyContract(ContractVO vo); // 수정
	
	// 조달 계획 등록
	List<ProcurementPlanVO> getProcurementPlan(Criteria cri); // 목록 가져오기
	Integer registerProcurementPlan(List<ProcurementPlanVO> list); // 등록
	Integer deleteProcurementPlan(Integer pp_code); // 삭제
	Integer modifyProcurementPlan(ProcurementPlanVO vo); // 수정
	
}
