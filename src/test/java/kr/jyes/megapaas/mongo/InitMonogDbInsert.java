package kr.jyes.megapaas.mongo;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import kr.jyes.megapaas.model.CommonCode;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
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
public class InitMonogDbInsert {
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Before
	public void setUp() throws Exception {
	}

	@Ignore
	@Test
	public void test_codeData_Insert() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		File file = new File("C:\\Users\\kikimans\\git\\megapaas\\src\\test\\resources\\data\\initData.json");
		
		List<CommonCode> codes = mapper.readValue(file, new TypeReference<List<CommonCode>>(){} );
		
		for(CommonCode cd : codes){
			mongoTemplate.save(cd, "code");
		}
		
	}
	
	@Test
	public void test_data_확인(){
		for(CommonCode cd : mongoTemplate.findAll(CommonCode.class)){
			System.out.println(cd);
		}
	}

}
