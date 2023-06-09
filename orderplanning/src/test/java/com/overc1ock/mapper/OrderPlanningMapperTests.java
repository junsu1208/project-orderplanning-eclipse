package com.overc1ock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.overc1ock.domain.ItemInfoVO;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class OrderPlanningMapperTests {

	@Autowired
	OrderPlanningMapper mapper;
	
	@Test
	public void testGetItemInfo() {
//		for (ItemInfoVO vo : mapper.getItemInfo()) {
//		log.info(vo);
//	}
		// 위와 동일한 의미로 간략하게 작성
		mapper.getItemInfo().forEach(vo -> log.info(vo));
	}
	
	@Test
	public void testSaveItemInfo() {
		ItemInfoVO vo = new ItemInfoVO();
		vo.setItem_name("테스트 품목");
		vo.setStandard("테스트 규격");
		vo.setMaterial("테스트 재질");
		vo.setSpecification_file("테스트 제작 사양 파일");
		vo.setDraw_file("테스트 도면 파일");
		vo.setSc_code(1);
		mapper.saveItemInfo(vo);
		log.info(vo);
	}
	
	@Test
	public void testGetContract() {
		mapper.getContract().forEach(vo -> log.info(vo));
	}
	
	@Test
	public void testGetProcurementPlan() {
		mapper.getProcurementPlan().forEach(vo -> log.info(vo));
	}
	
}
