package com.overc1ock.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.overc1ock.domain.ProcurementPlanVO;
import com.overc1ock.mapper.OrderPlanningMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class ProcurementPlanServiceImpl implements ProcurementPlanService {
	
	OrderPlanningMapper mapper;
	
	@Override
	public List<ProcurementPlanVO> getProcurementPlan() {
		log.info("조달 예정 품목 목록 요청");
		return mapper.getProcurementPlan();
	}
	
	@Override
	public List<ProcurementPlanVO> getItemCodeForProcurementPlan() {
		return mapper.getItemCodeForProcurementPlan();
	}
	
	@Override
	public List<ProcurementPlanVO> getItemNameForProcurementPlan() {
		return mapper.getItemNameForProcurementPlan();
	}

	@Override
	public void registerProcurementPlan(ProcurementPlanVO vo) {
		log.info("조달 계획 등록 요청, 변수값: " + vo);
		mapper.registerProcurementPlan(vo);
	}
	
	@Override
	public ProcurementPlanVO inquiryProcurementPlan(Integer pp_code) {
		log.info("조달 계획 조회 요청, 변수값: " + pp_code);
		return mapper.inquiryProcurementPlan(pp_code);
	}
	
	@Override
	public boolean deleteProcurementPlan(Integer pp_code) {
		log.info("조달 계획 삭제 요청, 변수값: " + pp_code);
		return mapper.deleteProcurementPlan(pp_code) == 1;
	}

	@Override
	public boolean modifyProcurementPlan(ProcurementPlanVO vo) {
		log.info("조달 계획 수정 요청, 변수값: " + vo);
		return mapper.modifyProcurementPlan(vo) == 1;
	}

}
