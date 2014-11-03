package kr.jyes.megapaas.mongo;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import kr.jyes.megapaas.model.OpenShiftStatus;
import kr.jyes.megapaas.repository.OpenShiftStatusRepository;

import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { 
"file:src/main/webapp/WEB-INF/config/spring/application-servlet.xml",
"file:src/main/resources/spring/context-root.xml"})
public class OpenShiftStatusRepoTest {

	@Autowired private OpenShiftStatusRepository statusRepo;
	
	String status_id;
	
	@Before
	public void setUp() throws Exception {
		status_id = "544f5c4907dbfcca0e9a68ba";
	}
	
	@Test
	public void test_data_check(){
		
		assertThat(statusRepo.findOne(new ObjectId(status_id)).getId().toString(), is(status_id));
	}

	@Test
	public void test_사용자_상태_승인여부_변경() {
		//statusRepo.find
		OpenShiftStatus status = statusRepo.findOne(new ObjectId(status_id));
		
		int status_cd = status.getStatus_cd().getCode();
		status_cd = 1002;
		
		OpenShiftStatus newStatus = statusRepo.updateUserStatus_cd(status, status_cd);
		
		assertThat(newStatus.getStatus_cd().getCode(), is(status_cd));
		
	}
	
	@Test
	public void test_사용자_상태_기어타입_변경(){
		OpenShiftStatus status = statusRepo.findOne(new ObjectId(status_id));
		
		int gearType_cd = status.getGeartype_cd().getCode();
		gearType_cd =2001;
		
		OpenShiftStatus newStatus = statusRepo.updateUserGearType_cd(status, gearType_cd);
		
		assertThat(newStatus.getGeartype_cd().getCode(), is(gearType_cd));
	}
	
	@Test
	public void test_사용자_상태_Consumed_gear_cnt_변경(){
		OpenShiftStatus status = statusRepo.findOne(new ObjectId(status_id));
		
		int current_consumed_cnt = status.getConsumed_gear();
		//application 생성
		
		int new_consumed_cnt =current_consumed_cnt +1;
		
		OpenShiftStatus newStatus = statusRepo.updateUserConsumedGear(status, new_consumed_cnt);
		
		assertThat(newStatus.getConsumed_gear(), is(new_consumed_cnt));
	}

}
