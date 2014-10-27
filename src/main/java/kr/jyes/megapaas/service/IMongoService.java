package kr.jyes.megapaas.service;

import java.util.List;

import kr.jyes.megapaas.model.CommonCode;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
public interface IMongoService {

	void saveCode(CommonCode code);

	List<CommonCode> getCodeAll();

	

}
