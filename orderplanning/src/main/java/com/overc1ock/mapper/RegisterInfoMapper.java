package com.overc1ock.mapper;

import java.util.List;

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

}
