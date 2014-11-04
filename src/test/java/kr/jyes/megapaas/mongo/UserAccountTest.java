package kr.jyes.megapaas.mongo;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import kr.jyes.megapaas.model.OpenShiftStatus;
import kr.jyes.megapaas.model.UserAccount;
import kr.jyes.megapaas.repository.CodeRepository;
import kr.jyes.megapaas.repository.OpenShiftStatusRepository;
import kr.jyes.megapaas.repository.UserAccountRepository;

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
public class UserAccountTest {
	
	@Autowired private UserAccountRepository accountRepository;
	@Autowired private CodeRepository codeRepo;
	@Autowired private OpenShiftStatusRepository statusRepository;
	

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test_이메일로_가져오기() {
		String email = "kikimans@gmail.com";
		
		UserAccount user = accountRepository.findByEmail(email);
		
		assertThat(user, is(notNullValue()));
		
	}
	
	@Test
	public void test_사용자등록(){
		UserAccount accountUser = new UserAccount();		
		ObjectId id = new ObjectId();
		
		accountUser.setId(id);
		accountUser.setEmail("kikimans@jyes.co.kr");
		accountUser.setMobile("01034887008");
		accountUser.setName("lucas");
		accountUser.setPassword("alsgh@1716");
		OpenShiftStatus status = new OpenShiftStatus(codeRepo.getCodeData(1001), codeRepo.getCodeData(2001), id);
		accountUser.setStatus(status);
		accountUser.setOpenshiftStatus_id(status.getId());
		
		accountRepository.save(accountUser);
		
		assertThat(accountRepository.findOne(id).getEmail(), is("kikimans@jyes.co.kr"));
		
		OpenShiftStatus insertStatus = statusRepository.findByOwnerId(id);
		assertThat(insertStatus.getGeartype_cd().getCode(), is(2001));
		
	}
	
	@Test
	public void test_사용자_삭제(){
		accountRepository.delete(new ObjectId("54586d84f6196093d3cfb336"));
	}
	
	

}
