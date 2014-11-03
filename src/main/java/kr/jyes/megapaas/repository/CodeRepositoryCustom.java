package kr.jyes.megapaas.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.jyes.megapaas.model.CommonCode;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
@Repository
public interface CodeRepositoryCustom {
	
	/**
	 * <pre>
	 * 1. 개요 : 코드값으로 공통코드를 가져오기
	 * 2. 처리내용 : 코드값으로 검색하여 공통 코드를 리턴한다. 
	 * </pre>
	 *
	 * @Method : getCodeData
	 * @Return : CommonCode
	 * @date   : 2014. 11. 3.
	 * @author : kikimans
	 * @history : 
	 * ------------------------------------------------------------------------------------------
	 *   변경일			작성자					변경내용			
	 * -----------	-----------------	---------------------------------------------------------
	 *	 2014. 11. 3.		kikimans					최초작성
	 * ------------------------------------------------------------------------------------------
	 *
	 * @param code
	 * @return
	 */
	CommonCode getCodeData(int code);
	/**
	 * <pre>
	 * 1. 개요 : 코드 네임으로 값 찾기
	 * 2. 처리내용 : 코드 네임으로 찾은 공통코드 리스트를 코드 값만 리턴하다
	 * </pre>
	 *
	 * @Method : findByNameCodes
	 * @Return : List<Integer>
	 * @date   : 2014. 11. 3.
	 * @author : kikimans
	 * @history : 
	 * ------------------------------------------------------------------------------------------
	 *   변경일			작성자					변경내용			
	 * -----------	-----------------	---------------------------------------------------------
	 *	 2014. 11. 3.		kikimans					최초작성
	 * ------------------------------------------------------------------------------------------
	 *
	 * @param string
	 * @return
	 */
	List<Integer> findByNameCodes(String string);
	
}
