package com.overc1ock.service;

import java.util.List;

import com.overc1ock.domain.SubcontractorVO;

public interface SubcontractorService {
	
	// 협력 업체 등록
	List<SubcontractorVO> getSubcontractor(); // 목록 가져오기
	void registerSubcontractor(SubcontractorVO vo); // 등록

}
