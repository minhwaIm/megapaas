/**
 * 
 */
package kr.jyes.megapaas.model;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
/**
 * <pre>
 * kr.jyes.megapaas.model
 * AbstractObject.java
 * </pre>
 *
 * @author  : kikimans
 * @Date    : 2014. 11. 3.
 * @Version : 
 */
public class AbstractObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id private ObjectId id;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}
	
	
	
	
	
}
