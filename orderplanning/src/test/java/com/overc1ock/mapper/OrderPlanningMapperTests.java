package com.overc1ock.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.overc1ock.domain.ContractVO;
import com.overc1ock.domain.Criteria;
import com.overc1ock.domain.ItemInfoVO;
import com.overc1ock.domain.ProcurementPlanVO;

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
	public void testRegisterItemInfo() {
		ItemInfoVO vo = new ItemInfoVO();
		vo.setItem_name("테스트 품목");
		vo.setStandard("테스트 규격");
		vo.setMaterial("테스트 재질");
		vo.setSpecification_file("테스트 제작 사양 파일");
		vo.setDraw_file("테스트 도면 파일");
//		vo.setSc_name(?);
		mapper.registerItemInfo(vo);
	}
	
	@Test
	public void testInquiryItemInfo() {
		mapper.inquiryItemInfo("1");
	}
	
	@Test
	public void testDeleteItemInfo() {
		mapper.deleteItemInfo("27");
	}
	
	@Test
	public void testModifyItemInfo() {
		ItemInfoVO vo = new ItemInfoVO();
		vo.setItem_name("수정된 품목");
		vo.setStandard("수정된 규격");
		vo.setMaterial("수정된 재질");
		vo.setSpecification_file("수정된 제작 사양 파일");
		vo.setDraw_file("수정된 도면 파일");
//		vo.setSc_code(2);
		vo.setItem_code("30");
		mapper.modifyItemInfo(vo);
	}
	
	@Test
	public void testGetContract() {
		mapper.getContract().forEach(vo -> log.info(vo));
	}
	
	@Test
	public void testRegisterContract() {
		ContractVO vo = new ContractVO();
		vo.setContract_name("테스트 계약서");
		vo.setSubcontractor_name("(주)애니웨어컴퍼니");
		vo.setItem_code("5");
		vo.setSupply_price(1000);
		vo.setAgreement_date("2023-06-12");
		vo.setLeadtime(10);
		vo.setContract_file("테스트 계약서 파일");
		vo.setContract_text("테스트 비고");
		mapper.registerContract(vo);
	}
	
	@Test
	public void testInquiryContract() {
		mapper.inquiryContract(1);
	}
	
	@Test
	public void testDeleteContract() {
		mapper.deleteContract(27);
	}
	
	@Test
	public void testModifyContract() {
		ContractVO vo = new ContractVO();
		vo.setContract_name("수정된 계약서");
		vo.setSubcontractor_name("(유)길승산업");
		vo.setItem_code("1");
		vo.setSupply_price(1500);
		vo.setAgreement_date("2023-06-14");
		vo.setLeadtime(20);
		vo.setContract_file("수정된 계약서 파일");
		vo.setContract_text("수정된 비고");
		vo.setContract_code(30);
		mapper.modifyContract(vo);
	}
	
	@Test
	public void testGetProcurementPlan() {
		Criteria cri = new Criteria();
		mapper.getProcurementPlan(cri).forEach(vo -> log.info(vo));
	}
	
	@Test
	public void testRegisterProcurementPlan() {
		List<ProcurementPlanVO> list = new ArrayList<ProcurementPlanVO>();
		ProcurementPlanVO vo1 = new ProcurementPlanVO();
		vo1.setProcurement_date(new Date());
		vo1.setIup_code(12);
		list.add(vo1);
		ProcurementPlanVO vo2 = new ProcurementPlanVO();
		vo1.setProcurement_date(new Date());
		vo1.setIup_code(13);
		list.add(vo2);
		mapper.registerProcurementPlan(list);
	}
	
}
