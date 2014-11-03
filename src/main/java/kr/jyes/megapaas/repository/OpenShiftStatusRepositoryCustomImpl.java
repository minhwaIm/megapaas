/**
 * 
 */
package kr.jyes.megapaas.repository;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import kr.jyes.megapaas.model.CommonCode;
import kr.jyes.megapaas.model.OpenShiftStatus;
import kr.jyes.megapass.exception.MegaPaasMongoRepositoryException;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
/**
 * <pre>
 * kr.jyes.megapaas.repository
 * OpenShiftStatusCustomImpl.java
 * </pre>
 *
 * @author  : kikimans
 * @Date    : 2014. 11. 3.
 * @Version : 
 */
public class OpenShiftStatusRepositoryCustomImpl implements OpenShiftStatusRepositoryCustom {
	
	@Autowired private MongoTemplate mongoTemplate;
	
	@Autowired private CodeRepository codeRepo;
	
	private static final String COLLECTION_NAME="openshiftStatus";
	
	private OpenShiftStatus findById(String _id) {
		// TODO Auto-generated method stub
		if(_id == null && _id.equals("")){
			throw new MegaPaasMongoRepositoryException("Could not find parameter \"{0}\" in resource \"{1}\"", "OpenShiftStatus Object Id", getClass().getSimpleName());
		}
		ObjectId id = new ObjectId(_id);
		return mongoTemplate.findById(id, OpenShiftStatus.class);
	}

	@Override
	public OpenShiftStatus updateUserStatus_cd(OpenShiftStatus status,
			int status_cd) throws MegaPaasMongoRepositoryException {
		// TODO Auto-generated method stub
		String keyName = "status_cd";
		if(status == null){
			throw new MegaPaasMongoRepositoryException("Could not find parameter \"{0}\" in resource \"{1}\"", "OpenShiftStatus", getClass().getSimpleName());
		}
		CommonCode cd = codeRepo.getCodeData(status_cd);
		
		if(cd == null){
			throw new MegaPaasMongoRepositoryException("Could not find parameter \"{0}\" in resource \"{1}\"", "CommonCode", getClass().getSimpleName());
		}	
		
		if(!isCommonCd(keyName, status_cd)){
			throw new MegaPaasMongoRepositoryException("Wrong parameter \"{0}\" in resource \"{1}\"", keyName, getClass().getSimpleName());
		}	
		
		status.setStatus_cd(cd);
		status.setUpdate_dt(new Date());
		mongoTemplate.save(status, COLLECTION_NAME);
		return findById(status.getId().toString());
	}

	

	@Override
	public OpenShiftStatus updateUserGearType_cd(OpenShiftStatus status,
			int gearType_cd) throws MegaPaasMongoRepositoryException {
		// TODO Auto-generated method stub
		String keyName = "geartype_cd";
		if(status == null){
			throw new MegaPaasMongoRepositoryException("Could not find parameter \"{0}\" in resource \"{1}\"", "OpenShiftStatus", getClass().getSimpleName());
		}
		CommonCode cd = codeRepo.getCodeData(gearType_cd);
		
		if(cd == null){
			throw new MegaPaasMongoRepositoryException("Could not find parameter \"{0}\" in resource \"{1}\"", "CommonCode", getClass().getSimpleName());
		}
		
		if(!isCommonCd(keyName, gearType_cd)){
			throw new MegaPaasMongoRepositoryException("Wrong parameter \"{0}\" in resource \"{1}\"", keyName, getClass().getSimpleName());
		}	
		
		status.setGeartype_cd(cd);
		status.setUpdate_dt(new Date());
		mongoTemplate.save(status, COLLECTION_NAME);
		return findById(status.getId().toString());
	}

	@Override
	public OpenShiftStatus updateUserConsumedGear(OpenShiftStatus status,
			int consumed_gear_cnt) throws MegaPaasMongoRepositoryException {
		// TODO Auto-generated method stub
		if(status == null){
			throw new MegaPaasMongoRepositoryException("Could not find parameter \"{0}\" in resource \"{1}\"", "OpenShiftStatus", getClass().getSimpleName());
		}		
		
		status.setConsumed_gear(consumed_gear_cnt);
		status.setUpdate_dt(new Date());
		mongoTemplate.save(status, COLLECTION_NAME);
		return findById(status.getId().toString());
	}
	
	@SuppressWarnings("unused")
	private boolean isCommonCd(String keyName, int cd){
		
		List<Integer> statusCds = codeRepo.findByNameCodes(keyName);
		if(statusCds.contains(cd)){
			return true;
		}else{
			return false;
		}	
		
	}

}
