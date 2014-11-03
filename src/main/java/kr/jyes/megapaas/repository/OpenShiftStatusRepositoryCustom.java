package kr.jyes.megapaas.repository;

import kr.jyes.megapaas.model.OpenShiftStatus;
import kr.jyes.megapass.exception.MegaPaasMongoRepositoryException;

import org.springframework.stereotype.Repository;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
@Repository
public interface OpenShiftStatusRepositoryCustom {

	/**
	 * <pre>
	 * 1. 개요 : 사용자 승인 상태 변경
	 * 2. 처리내용 : 사용자의 상태 정보에서 승인 상태값을 변경 한다.
	 * </pre>
	 *
	 * @Method : updateUserStatus_cd
	 * @Return : OpenShiftStatus
	 * @date   : 2014. 11. 3.
	 * @author : kikimans
	 * @history : 
	 * ------------------------------------------------------------------------------------------
	 *   변경일			작성자					변경내용			
	 * -----------	-----------------	---------------------------------------------------------
	 *	 2014. 11. 3.		kikimans					최초작성
	 * ------------------------------------------------------------------------------------------
	 *
	 * @param status
	 * @param status_cd
	 * @return
	 * @throws MegaPaasMongoRepositoryException
	 */
	OpenShiftStatus updateUserStatus_cd(OpenShiftStatus status, int status_cd) throws MegaPaasMongoRepositoryException;
	/**
	 * <pre>
	 * 1. 개요 : 사용자의 기어 타입 변경
	 * 2. 처리내용 : 사용자의 상태 값 중 기어 타입을 코드 값으로 변경 한다.
	 * </pre>
	 *
	 * @Method : updateUserGearType_cd
	 * @Return : OpenShiftStatus
	 * @date   : 2014. 11. 3.
	 * @author : kikimans
	 * @history : 
	 * ------------------------------------------------------------------------------------------
	 *   변경일			작성자					변경내용			
	 * -----------	-----------------	---------------------------------------------------------
	 *	 2014. 11. 3.		kikimans					최초작성
	 * ------------------------------------------------------------------------------------------
	 *
	 * @param status
	 * @param gearType_cd
	 * @return
	 * @throws MegaPaasMongoRepositoryException
	 */
	OpenShiftStatus updateUserGearType_cd(OpenShiftStatus status, int gearType_cd) throws MegaPaasMongoRepositoryException;
	/**
	 * <pre>
	 * 1. 개요 : 카트리지 생성 및 삭제시 변경 처리 한다.
	 * 2. 처리내용 : 카트리지 생성시 현재 데이터에서 +1, 카트리지 삭제시 현재 데이터에서 -1
	 * </pre>
	 *
	 * @Method : updateUserConsumedGear
	 * @Return : OpenShiftStatus
	 * @date   : 2014. 11. 3.
	 * @author : kikimans
	 * @history : 
	 * ------------------------------------------------------------------------------------------
	 *   변경일			작성자					변경내용			
	 * -----------	-----------------	---------------------------------------------------------
	 *	 2014. 11. 3.		kikimans					최초작성
	 * ------------------------------------------------------------------------------------------
	 *
	 * @param status
	 * @param consumed_gear_cnt
	 * @return
	 * @throws MegaPaasMongoRepositoryException
	 */
	OpenShiftStatus updateUserConsumedGear(OpenShiftStatus status, int consumed_gear_cnt) throws MegaPaasMongoRepositoryException;
}
