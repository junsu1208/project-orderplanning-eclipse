package com.overc1ock.mapper;

import java.util.List;

import com.overc1ock.domain.ItemUsePlanVO;
import com.overc1ock.domain.ProductionPlanVO;
import com.overc1ock.domain.SubcontractorVO;

public interface RegisterInfoMapper {
	
	// 협력 업체 등록
	List<SubcontractorVO> getSubcontractor(); // 목록 가져오기
	void registerSubcontractor(SubcontractorVO vo); // 등록
	
	// 제품 생산 계획 등록
	List<ProductionPlanVO> getProductionPlan(); // 목록 가져오기
	List<ProductionPlanVO> getProductName(); // 제품명 가져오기
	void registerProductionPlan(ProductionPlanVO vo); // 등록
	
	// 품목 사용 계획 등록
	List<ItemUsePlanVO> getItemUsePlan(); // 목록 가져오기
	List<ItemUsePlanVO> getPppCode(); // 제품 생산 계획 코드 가져오기
	List<ItemUsePlanVO> getItemCode(); // 품목 코드 가져오기
	void registerItemUsePlan(ItemUsePlanVO vo); // 등록

}
