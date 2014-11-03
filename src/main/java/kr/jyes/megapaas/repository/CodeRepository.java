/**
 * 
 */
package kr.jyes.megapaas.repository;

import java.util.List;

import kr.jyes.megapaas.model.CommonCode;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
/**
 * <pre>
 * kr.jyes.megapaas.repository
 * ICodeRepository.java
 * </pre>
 *
 * @author  : kikimans
 * @Date    : 2014. 11. 3.
 * @Version : 
 */
@Repository
public interface CodeRepository extends MongoRepository<CommonCode, ObjectId>,
		CodeRepositoryCustom {
	
	List<CommonCode> findByCode(int code);
	CommonCode findOneByCode(int code);
	List<CommonCode> findAll();
	List<CommonCode> findByName(String name);
	


}
