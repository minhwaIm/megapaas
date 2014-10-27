/**
 * 
 */
package kr.jyes.megapaas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
/**
 * <pre>
 * kr.jyes.megapaas.controller
 * IndexController.java
 * </pre>
 *
 * @author  : kikimans
 * @Date    : 2014. 10. 27.
 * @Version : 
 */
@Controller
public class IndexController {

	/**
	 * <pre>
	 * 1. 개요 : main page method
	 * 2. 처리내용 : index page return 
	 * </pre>
	 *
	 * @Method : index
	 * @Return : String
	 * @date   : 2014. 10. 27.
	 * @author : kikimans
	 * @history : 
	 * ------------------------------------------------------------------------------------------
	 *   변경일			작성자					변경내용			
	 * -----------	-----------------	---------------------------------------------------------
	 *	 2014. 10. 27.		kikimans					최초작성
	 * ------------------------------------------------------------------------------------------
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/index.paas", method=RequestMethod.GET )
	public String index(Model model){
		
		return "index";
	}
}
