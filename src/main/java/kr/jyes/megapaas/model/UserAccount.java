/**
 * 
 */
package kr.jyes.megapaas.model;

import java.io.Serializable;
import java.util.Date;

import kr.jyes.megapaas.mongo.CascadeSave;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
/**
 * <pre>
 * kr.jyes.megapaas.model
 * UserAccount.java
 * </pre>
 *
 * @author  : kikimans
 * @Date    : 2014. 10. 27.
 * @Version : 
 */
@Document(collection="userAccount")
public class UserAccount extends AbstractMegaObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String mobile;
	private String email;
	private String password;
	private String desc;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date insert_dt;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date update_dt = new Date();
	
	@DBRef(lazy = true)
	@CascadeSave 
	private OpenShiftStatus status;	
	
	private ObjectId openshiftStatus_id;
	
	public UserAccount(){
		super(new ObjectId());
		this.insert_dt = new Date();
	}	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getInsert_dt() {
		return insert_dt;
	}
	public void setInsert_dt(Date insert_dt) {
		this.insert_dt = insert_dt;
	}
	public Date getUpdate_dt() {
		return update_dt;
	}
	public void setUpdate_dt(Date update_dt) {
		this.update_dt = update_dt;
	}	
	
	public ObjectId getOpenshiftStatus_id() {
		return openshiftStatus_id;
	}
	public void setOpenshiftStatus_id(ObjectId openshiftStatus_id) {
		this.openshiftStatus_id = openshiftStatus_id;
	}
	
	public OpenShiftStatus getStatus() {		
		
		return status;
	}
	
	
	public void setStatus(OpenShiftStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserAccount [name=");
		builder.append(name);
		builder.append(", mobile=");
		builder.append(mobile);
		builder.append(", email=");
		builder.append(email);
		builder.append(", password=");
		builder.append(password);
		builder.append(", desc=");
		builder.append(desc);
		builder.append(", insert_dt=");
		builder.append(insert_dt);
		builder.append(", update_dt=");
		builder.append(update_dt);
		builder.append(", status=");
		builder.append(status);
		builder.append(", openshiftStatus_id=");
		builder.append(openshiftStatus_id);
		builder.append("]");
		return builder.toString();
	}

	
	
	
	
	
}
