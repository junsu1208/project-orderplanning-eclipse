package com.overc1ock.mapper;

import java.util.List;

import com.overc1ock.domain.SubcontractorVO;

public interface RegisterInfoMapper {
	
	// 협력 업체 등록
	List<SubcontractorVO> getSubcontractor(); // 목록 가져오기
	void registerSubcontractor(SubcontractorVO vo); // 등록

}
