package kr.jyes.megapaas.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kr.jyes.megapaas.model.CommonCode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
/**
 * <pre>
 * kr.jyes.megapaas.repository.custom
 * CodeRepositoryCustom.java
 * </pre>
 *
 * @author  : kikimans
 * @Date    : 2014. 11. 3.
 * @Version : 1.0
 * @Date         : 2014. 10. 28. 
 * @작성자      : kikimans
 * @변경이력 :
 * @프로그램 설명 : 공통코드 Custom Repository
 */

public class CodeRepositoryCustomImpl implements CodeRepositoryCustom {
	
	private static final Logger logger = LoggerFactory.getLogger(CodeRepositoryCustomImpl.class);
	private static final String COLLECTION_NAME = "code";
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public CommonCode getCodeData(int code) {
		// TODO Auto-generated method stub
		Query query = new Query();
		query.addCriteria(Criteria.where("code").is(code));
		return mongoTemplate.findOne(query, CommonCode.class);
	}

	@Override
	public List<Integer> findByNameCodes(String key) {
		// TODO Auto-generated method stub
		Query query  = new Query();
		query.addCriteria(Criteria.where("name").is(key));
		List<CommonCode> codes = mongoTemplate.find(query, CommonCode.class);
		
		List<Integer> intCodes = new ArrayList<Integer>();
		for(CommonCode cd : codes){
			intCodes.add(cd.getCode());
		}
		return intCodes;
	}
	
	
	

	

}
