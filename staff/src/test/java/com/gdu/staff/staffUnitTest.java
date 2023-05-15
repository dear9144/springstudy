package com.gdu.staff;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.gdu.staff.domain.StaffDTO;
import com.gdu.staff.mapper.StaffMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class staffUnitTest {
	@Autowired
	private StaffMapper staffMapper;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(staffUnitTest.class);
	
	@Test
	public void a1등록테스트() {
		StaffDTO staffDTO = new StaffDTO("사원번호" ,"사원명", "부서명", 0);
		assertEquals(99999, staffDTO.getSno());
	}
	
	@Test
	public void a2조회테스트() {
		StaffDTO staffDTO = new StaffDTO("사원번호", null, null, 0);
		assertEquals(11111, staffDTO.getSno());
	}
	
	
	
}
