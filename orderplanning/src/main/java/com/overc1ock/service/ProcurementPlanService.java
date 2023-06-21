package com.overc1ock.service;

import java.util.List;

import com.overc1ock.domain.Criteria;
import com.overc1ock.domain.ProcurementPlanVO;

public interface ProcurementPlanService {
	
	// 조달 계획 등록
	List<ProcurementPlanVO> getProcurementPlan(Criteria cri); // 목록 가져오기
	void registerProcurementPlan(List<ProcurementPlanVO> list); // 등록
	Integer deleteProcurementPlan(Integer pp_code); // 삭제
	boolean modifyProcurementPlan(ProcurementPlanVO vo); // 수정

}
