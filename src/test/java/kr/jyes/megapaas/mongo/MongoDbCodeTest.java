package kr.jyes.megapaas.mongo;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import kr.jyes.megapaas.model.CommonCode;
import kr.jyes.megapaas.repository.CodeRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class MongoDbCodeTest {
	
	private static final Logger logger = LoggerFactory.getLogger(MongoDbCodeTest.class);	
	
	@Autowired
	private CodeRepository codeRepo;

	@Before
	public void setUp() throws Exception {
	}

	
	@Test
	public void test_code_하나(){
		CommonCode cd = codeRepo.getCodeData(1001);
		assertThat(cd, is(notNullValue()));
	}
	
	

	
	

}
