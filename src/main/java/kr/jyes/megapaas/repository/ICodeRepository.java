package kr.jyes.megapaas.repository;

import java.util.List;

import kr.jyes.megapaas.model.CommonCode;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */

public interface ICodeRepository {	

	List<CommonCode> listCode();
	void createCode(CommonCode code);
	void deleteCode(CommonCode cd);
	int updateCode(CommonCode code);

}
