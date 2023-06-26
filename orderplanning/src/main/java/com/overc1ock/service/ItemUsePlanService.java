package com.overc1ock.service;

import java.util.List;

import com.overc1ock.domain.ItemUsePlanVO;

public interface ItemUsePlanService {

	// 품목 사용 계획 등록
	List<ItemUsePlanVO> getItemUsePlan(); // 목록 가져오기
	List<ItemUsePlanVO> getPppCode(); // 제품 생산 계획 코드 가져오기
	List<ItemUsePlanVO> getItemCode(); // 품목 코드 가져오기
	void registerItemUsePlan(ItemUsePlanVO vo); // 등록
	
}
