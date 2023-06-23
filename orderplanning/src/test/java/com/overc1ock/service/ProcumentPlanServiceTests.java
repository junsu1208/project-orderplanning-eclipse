package com.overc1ock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.overc1ock.domain.Criteria;
import com.overc1ock.mapper.OrderPlanningMapper;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ProcumentPlanServiceTests {
	
	@Autowired
	OrderPlanningMapper mapper;
	
	@Test
	public void testGetProcurementPlan() {
		Criteria cri = new Criteria();
		mapper.getProcurementPlan(cri).forEach(vo -> log.info(vo));
	}

}
