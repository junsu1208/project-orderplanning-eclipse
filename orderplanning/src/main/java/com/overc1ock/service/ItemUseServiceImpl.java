package com.overc1ock.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.overc1ock.domain.ItemUsePlanVO;
import com.overc1ock.mapper.RegisterInfoMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class ItemUseServiceImpl implements ItemUsePlanService {
	
	RegisterInfoMapper mapper;
	
	@Override
	public List<ItemUsePlanVO> getItemUsePlan() {
		log.info("품목 사용 계획 목록 요청");
		return mapper.getItemUsePlan();
	}

	@Override
	public List<ItemUsePlanVO> getPppCode() {
		return mapper.getPppCode();
	}

	@Override
	public List<ItemUsePlanVO> getItemCode() {
		return mapper.getItemCode();
	}

	@Override
	public void registerItemUsePlan(ItemUsePlanVO vo) {
		log.info("품목 사용 계획 등록 요청, 변수값: " + vo);
		mapper.registerItemUsePlan(vo);
	}

}
