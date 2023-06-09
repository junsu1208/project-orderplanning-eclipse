package com.overc1ock.service;

import java.util.List;

import com.overc1ock.domain.ItemInfoVO;

public interface ItemInfoService {
	
	// 품목 정보 등록
	List<ItemInfoVO> getItemInfo(); // 목록 가져오기
	void saveItemInfo(ItemInfoVO vo); // 저장
	ItemInfoVO inquiryItemInfo(Long item_code); // 조회
	boolean deleteItemInfo(Long item_code); // 삭제
	boolean modifyItemInfo(Long item_code); // 수정

}
