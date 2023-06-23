package com.overc1ock.service;

import java.util.List;

import com.overc1ock.domain.ProductionPlanVO;

public interface ProductionPlanService {
	
	// 제품 생산 계획 등록
	List<ProductionPlanVO> getProductionPlan(); // 목록 가져오기
	List<ProductionPlanVO> getProductName(); // 제품명 가져오기
	void registerProductionPlan(ProductionPlanVO vo); // 등록

}
