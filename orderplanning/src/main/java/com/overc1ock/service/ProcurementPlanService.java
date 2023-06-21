package com.overc1ock.service;

import java.util.List;

import com.overc1ock.domain.ProcurementPlanVO;

public interface ProcurementPlanService {
	
	// 조달 계획 등록
	List<ProcurementPlanVO> getProcurementPlan(); // 목록 가져오기
	List<ProcurementPlanVO> getItemCodeForProcurementPlan(); // 품목 코드 가져오기
	void registerProcurementPlan(ProcurementPlanVO vo); // 등록
	ProcurementPlanVO inquiryProcurementPlan(Long pp_code);// 조회
	boolean deleteProcurementPlan(Long pp_code); // 삭제
	boolean modifyProcurementPlan(ProcurementPlanVO vo); // 수정

}
