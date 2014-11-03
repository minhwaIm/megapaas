/**
 * 
 */
package kr.jyes.megapass.exception;

import java.text.MessageFormat;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
/**
 * <pre>
 * kr.jyes.megapass.exception
 * MegaPaasException.java
 * </pre>
 *
 * @author  : kikimans
 * @Date    : 2014. 10. 28.
 * @Version : 
 */
public class MegaPaasException extends RuntimeException {

	public MegaPaasException(Throwable cause, String message, Object... arguments) {
		super(MessageFormat.format(message, arguments), cause);
	}
	
	public MegaPaasException(String message, Object... arguments) {
		super(MessageFormat.format(message, arguments));
	}
}
