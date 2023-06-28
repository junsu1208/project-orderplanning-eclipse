package com.overc1ock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public List<ItemInfoVO> getMajorCategory() {
		log.info("대분류 목록 요청");
		return mapper.getMajorCategory();
	}
	
	@Override
	public List<ItemInfoVO> getSubCategory(Integer mc_code) {
		log.info("중분류 목록 요청");
		return mapper.getSubCategory(mc_code);
	}
	
	@Override
	@Transactional
	public Integer registerItemInfo(ItemInfoVO vo) {
		log.info("품목 정보 등록 요청, 변수값: " + vo);
		String firstCode = mapper.getMc_name(vo.getMc_code()).getMc_name().toUpperCase().substring(0, 1);
		String secondCode = mapper.getSc_name(vo.getSc_code()).getSc_name().toUpperCase().substring(0, 1);
		String itemCode = firstCode+secondCode;
		log.info("생성된 품목 코드 앞부분: " + itemCode);
		String getItemCode = mapper.getItemCode(itemCode).getItem_code();
		log.info(getItemCode);
		
		if (getItemCode.equals("0")) {
			vo.setItem_code(itemCode + "0001");
		}else {
			vo.setItem_code(itemCode + String.format("%04d", Integer.parseInt(getItemCode.substring(2, getItemCode.length())) + 1));
		}
		return mapper.registerItemInfo(vo);
	}
	
	@Override
	public ItemInfoVO inquiryItemInfo(String item_code) {
		log.info("품목 정보 조회 요청, 변수값: " + item_code);
		return mapper.inquiryItemInfo(item_code);
	}

	@Override
	public Integer deleteItemInfo(String item_code) {
		log.info("품목 정보 삭제 요청, 변수값: " + item_code);
		return mapper.deleteItemInfo(item_code);
	}

	@Override
	public Integer modifyItemInfo(ItemInfoVO vo) {
		log.info("품목 정보 수정 요청, 변수값: " + vo);
		return mapper.modifyItemInfo(vo);
	}

}
