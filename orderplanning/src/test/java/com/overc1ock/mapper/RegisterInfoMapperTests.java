package com.overc1ock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.overc1ock.domain.ProductionPlanVO;
import com.overc1ock.domain.SubcontractorVO;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class RegisterInfoMapperTests {
	
	@Autowired
	RegisterInfoMapper mapper;
	
	@Test
	public void testGetSubcontractor() {
		mapper.getSubcontractor().forEach(vo -> log.info(vo));
	}
	
	@Test
	public void testRegisterSubcontractor() {
		SubcontractorVO vo = new SubcontractorVO();
		vo.setSubcontractor_name("테스트 업체(3)");
		vo.setSubcontractor_person("테스트 담당자(3)");
		vo.setSubcontractor_tel("333-3333-3333");
		vo.setSubcontractor_email("test3@example.com");
		vo.setSubcontractor_address("테스트 주소(3)");
		mapper.registerSubcontractor(vo);
	}
	
	@Test
	public void testGetProductionPlan() {
		mapper.getProductionPlan().forEach(vo -> log.info(vo));
	}
	
	@Test
	public void testRegisterProductionPlan() {
		ProductionPlanVO vo = new ProductionPlanVO();
		vo.setProduct_name("test제품2");
		vo.setProduction(3000);
		vo.setProcess("H공정");
		vo.setProduction_date("2023-06-01");
		mapper.registerProductionPlan(vo);
	}

}
