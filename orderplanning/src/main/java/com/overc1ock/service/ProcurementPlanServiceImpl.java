package com.overc1ock.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.overc1ock.domain.Criteria;
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
	public List<ProcurementPlanVO> getProcurementPlan(Criteria cri) {
		log.info("조달 예정 품목 목록 요청");
		return mapper.getProcurementPlan(cri);
	}

	@Override
	public Integer registerProcurementPlan(List<ProcurementPlanVO> list) {
		list.forEach(vo -> log.info("조달 계획 등록 요청, 변수값: "+vo));
		return mapper.registerProcurementPlan(list);
	}
	
	@Override
	public Integer deleteProcurementPlan(Integer pp_code) {
		log.info("조달 계획 삭제 요청, 변수값: " + pp_code);
		return mapper.deleteProcurementPlan(pp_code);
	}

	@Override
	public Integer modifyProcurementPlan(ProcurementPlanVO vo) {
		log.info("조달 계획 수정 요청, 변수값: " + vo);
		return mapper.modifyProcurementPlan(vo);
	}

}
