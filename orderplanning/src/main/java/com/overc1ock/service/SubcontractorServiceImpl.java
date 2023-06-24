package com.overc1ock.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.overc1ock.domain.SubcontractorVO;
import com.overc1ock.mapper.RegisterInfoMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class SubcontractorServiceImpl implements SubcontractorService {
	
	RegisterInfoMapper mapper;

	@Override
	public List<SubcontractorVO> getSubcontractor() {
		log.info("협력 업체 목록 요청");
		return mapper.getSubcontractor();
	}

	@Override
	public void registerSubcontractor(SubcontractorVO vo) {
		log.info("협력 업체 등록 요청, 변수값: " + vo);
		mapper.registerSubcontractor(vo);
	}

}
