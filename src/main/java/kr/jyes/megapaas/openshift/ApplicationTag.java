package kr.jyes.megapaas.openshift;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
public class ApplicationTag implements IApplicationTag {

	private static final Logger logger = LoggerFactory.getLogger(ApplicationTag.class);
	
	private static final String TAG_JAVA = "java";
	private static final String TAG_PHP = "php";
	private static final String TAG_PYTHON = "python";
	private static final String TAG_NODEJS = "nodejs";
	private static final String TAG_PERL = "perl";
	private static final String TAG_RUBY = "ruby";
	private static final String TAG_DIY = "diy";
	private static final String TAG_INSTANCE = "instace_app";
	
	
	
	private HashMap<String,String[]> tag;
	
	
	
	
}
