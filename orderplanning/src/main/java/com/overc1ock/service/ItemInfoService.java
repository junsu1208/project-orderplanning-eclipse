package com.overc1ock.service;

import java.util.List;

import com.overc1ock.domain.ItemInfoVO;

public interface ItemInfoService {
	
	// 품목 정보 등록
	List<ItemInfoVO> getItemInfo(); // 목록 가져오기
	List<ItemInfoVO> getMajorCategory(); // 대분류 가져오기
	List<ItemInfoVO> getSubCategory(); // 중분류 가져오기
	void registerItemInfo(ItemInfoVO vo); // 등록
	ItemInfoVO inquiryItemInfo(String item_code); // 조회
	boolean deleteItemInfo(String item_code); // 삭제
	boolean modifyItemInfo(ItemInfoVO vo); // 수정

}
