package com.overc1ock.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.overc1ock.domain.ItemInfoVO;
import com.overc1ock.mapper.OrderPlanningMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class ItemInfoServiceImpl implements ItemInfoService {
	
	OrderPlanningMapper mapper;
	
	@Override
	public List<ItemInfoVO> getItemInfo() {
		log.info("품목 정보 목록 요청");
		return mapper.getItemInfo();
	}

	@Override
	public void saveItemInfo(ItemInfoVO vo) {
		log.info("품목 정보 저장 요청, 변수값: " + vo);
		mapper.saveItemInfo(vo);
	}

	@Override
	public ItemInfoVO inquiryItemInfo(Long item_code) {
		log.info("품목 정보 조회 요청, 변수값: " + item_code);
		return mapper.inquiryItemInfo(item_code);
	}

	@Override
	public boolean deleteItemInfo(Long item_code) {
		log.info("품목 정보 삭제 요청, 변수값: " + item_code);
		return mapper.deleteItemInfo(item_code) == 1;
	}

	@Override
	public boolean modifyItemInfo(ItemInfoVO vo) {
		log.info("품목 정보 수정 요청, 변수값: " + vo);
		return mapper.modifyItemInfo(vo) == 1;
	}

}