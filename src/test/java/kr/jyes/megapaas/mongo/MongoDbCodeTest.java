package kr.jyes.megapaas.mongo;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import kr.jyes.megapaas.model.CommonCode;
import kr.jyes.megapaas.model.OpenShiftStatus;
import kr.jyes.megapaas.repository.ICodeRepository;
import kr.jyes.megapaas.service.IMongoService;

import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private ICodeRepository codeRepo;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test_mongoDB_Connection() {
		logger.info("mongoTemplate : " + mongoTemplate);
		
		assertThat(mongoTemplate, is(notNullValue()));
		
	}
	
	@Test
	public void test_mongoDB_Collection(){
		Set<String> mCollectionSet = mongoTemplate.getCollectionNames();
		//assertThat(mCollectionSet.isEmpty(), is(false));
		for(Iterator iter = mCollectionSet.iterator(); iter.hasNext();){
			logger.info("Collection Name : " + iter.next());
		}
	}
	
	@Test
	public void test_mongoDB_Code_Collection(){
		CommonCode code = new CommonCode();
		
		code.setCode(1000);
		code.setValue("1");
		code.setName("status_cd");
		code.setDesc("사용자 신청 상태");
		code.setUseYn("Y");
		code.setRegister("kikimans");	
		
		mongoTemplate.save(code);
		
		List<CommonCode> codelist = mongoTemplate.findAll(CommonCode.class);
		
		for(CommonCode cd : codelist){
			System.out.println(cd);
		}	
	}
	
	@Test
	public void test_mongoDB_Code_Collection_Create_Refactor(){
		CommonCode code = new CommonCode();
		
		code.setId(new ObjectId());
		code.setCode(1000);
		code.setValue("4");
		code.setName("status_cd");
		code.setDesc("사용자 대기 상태");
		code.setUseYn("Y");
		code.setRegister("kikimans");	
		
		codeRepo.createCode(code);	
		
		List<CommonCode> codelist = mongoTemplate.find(new Query(Criteria.where("code").is(1000).and("value").is("3")), CommonCode.class);
		
		assertThat(codelist.size(), is(1));
			
	}
	
	@Test
	public void test_code_update(){
		List<CommonCode> codelist = mongoTemplate.find(new Query(Criteria.where("code").is(1000).and("value").is("3")), CommonCode.class);
		
		CommonCode code = codelist.get(0);
		
		code.setRegister("tester");
		
		
		
		codeRepo.updateCode(code);
	}
//	
//	@Test
//	public void test_mongoDB_Code_Collection_Refactor2(){
//		List<CommonCode> codelist = codeRepo.listCode();
//	}
//	
//	@Test
//	public void test_mongoDB_Code_삭제(){
//		List<CommonCode> codelist = mongoTemplate.findAll(CommonCode.class);
//		
//		for(CommonCode cd : codelist){
//			mongoTemplate.remove(cd);
//		}	
//	}
//	
//	@Test
//	public void test_mongoDB_Code_삭제_refactor(){
//		List<CommonCode> codelist = codeRepo.listCode();
//		
//		for(CommonCode cd : codelist){
//			codeRepo.deleteCode(cd);
//		}	
//	}
//	
//	@Test
//	public void test_mongoDB_Code_업데이트(){
//		Query query = new Query(Criteria.where("name").is("stauts_cd").and("useYn").is("Y"));
//		CommonCode code = codeRepo.findById(new Object());
//	}
//	
//	@Test
//	public void test_mongoDB_Code_status_cd_가져오기(){
//		
//		Query query = new Query(Criteria.where("name").is("status_cd").and("useYn").is("Y"));
//		
//		List<CommonCode> status_cd_list = mongoTemplate.find(query, CommonCode.class);
//		
//		for(CommonCode cd : status_cd_list){
//			System.out.println(cd);
//		}	
//	}
//	
//	@Test
//	public void test_Code_데이터_전부_가져오기(){
//		List<CommonCode> codelist = mongoTemplate.findAll(CommonCode.class);
//		
//		for(CommonCode cd : codelist){
//			System.out.println(cd);
//		}
//	}
	
//	@Test
//	public void test_mongoDB_OpenShiftStatus_Collection(){
//		
//		OpenShiftStatus status = new OpenShiftStatus();
//		
//		CommonCode status_cd = mongoTemplate.findById(new ObjectId("544dfe4607dbc5f1f0ce723f"), CommonCode.class);
//		
//		status.setStatus_cd(status_cd);
//		status.setInsert_dt(new Date());
//		status.setUpdate_dt(new Date());
//		
//		mongoTemplate.save(status);
//		
//		List<OpenShiftStatus> statuslist = mongoTemplate.findAll(OpenShiftStatus.class);
//		
//		System.out.println("statuslist size : " + statuslist.size());
//		for(OpenShiftStatus stat : statuslist){
//			System.out.println(stat);
//		}
//	}
	
	

}
