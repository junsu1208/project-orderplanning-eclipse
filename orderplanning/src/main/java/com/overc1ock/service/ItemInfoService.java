package com.overc1ock.service;

import java.util.List;

import com.overc1ock.domain.ItemInfoVO;

public interface ItemInfoService {
	
	// 품목 정보 등록
	List<ItemInfoVO> getItemInfo(); // 목록 가져오기
	List<ItemInfoVO> getMajorCategory(); // 대분류 가져오기
	List<ItemInfoVO> getSubCategory(Integer mc_code); // 중분류 가져오기
	Integer registerItemInfo(ItemInfoVO vo); // 등록
	ItemInfoVO inquiryItemInfo(String item_code); // 조회
	Integer deleteItemInfo(String item_code); // 삭제
	Integer modifyItemInfo(ItemInfoVO vo); // 수정

}
