package com.overc1ock.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.overc1ock.domain.ProductionPlanVO;
import com.overc1ock.mapper.RegisterInfoMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class ProductionPlanServiceImpl implements ProductionPlanService {
	
	RegisterInfoMapper mapper;

	@Override
	public List<ProductionPlanVO> getProductionPlan() {
		log.info("제품 생산 계획 목록 요청");
		return mapper.getProductionPlan();
	}

	@Override
	public List<ProductionPlanVO> getProductName() {
		return mapper.getProductName();
	}

	@Override
	public void registerProductionPlan(ProductionPlanVO vo) {
		log.info("제품 생산 계획 등록 요청, 변수값: " + vo);
		mapper.registerProductionPlan(vo);
	}
	
}
