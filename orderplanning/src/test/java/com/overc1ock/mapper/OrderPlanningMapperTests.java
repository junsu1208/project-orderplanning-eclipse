package com.overc1ock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
	
}
