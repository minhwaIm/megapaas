package kr.jyes.megapaas.mongo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import kr.jyes.megapaas.model.CommonCode;
import kr.jyes.megapaas.service.IMongoService;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
@Service
public class MongoService implements IMongoService {
	
	private static final Logger logger = LoggerFactory.getLogger(MongoService.class);
	
	@Autowired
	private MongoTemplate mongoTemplate;

	/* (non-Javadoc)
	 * @see kr.jyes.megapaas.service.IMongoService#createCode(kr.jyes.megapaas.model.CommonCode)
	 *
	 * <pre>
	 * 1. 개요 : 코드 생성
	 * 2. 처리내용 : 코드값을 mongoDB 에 insert
	 * </pre>
	 *
	 * @Method : createCode * 
	 * @date   : 2014. 10. 27.
	 * @author : kikimans
	 * @history : 
	 * ------------------------------------------------------------------------------------------
	 *   변경일			작성자					변경내용			
	 * -----------	-----------------	---------------------------------------------------------
	 *	 2014. 10. 27.		kikimans					최초작성
	 * ------------------------------------------------------------------------------------------
	 *
	 * @param code
	 */
	 
	@Override
	public void saveCode(CommonCode code) {
		// TODO Auto-generated method stub
		if(mongoTemplate == null){
			logger.error("mongoTempleate connection null");			
		}else{
			mongoTemplate.save(code);
		}
		
	}

	@Override
	public List<CommonCode> getCodeAll() {
		// TODO Auto-generated method stub
		return mongoTemplate.findAll(CommonCode.class);
	}

	

}
