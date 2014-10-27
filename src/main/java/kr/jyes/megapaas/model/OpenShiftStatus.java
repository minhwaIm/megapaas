/**
 * 
 */
package kr.jyes.megapaas.model;

import java.io.Serializable;
import java.util.Date;

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
 * OpenShiftStatus.java
 * </pre>
 *
 * @author  : kikimans
 * @Date    : 2014. 10. 27.
 * @Version : 
 */
@Document(collection="openshiftStatus")
public class OpenShiftStatus implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private ObjectId id;
	
	@DBRef
	private CommonCode status_cd;
	@DBRef
	private CommonCode geartype_cd;
	private int consumed_gear;
	private String desc;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date insert_dt;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date update_dt = new Date();
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public CommonCode getStatus_cd() {
		return status_cd;
	}
	public void setStatus_cd(CommonCode status_cd) {
		this.status_cd = status_cd;
	}
	public CommonCode getGeartype_cd() {
		return geartype_cd;
	}
	public void setGeartype_cd(CommonCode geartype_cd) {
		this.geartype_cd = geartype_cd;
	}
	public int getConsumed_gear() {
		return consumed_gear;
	}
	public void setConsumed_gear(int consumed_gear) {
		this.consumed_gear = consumed_gear;
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OpenShiftStatus [id=");
		builder.append(id);
		builder.append(", status_cd=");
		builder.append(status_cd);
		builder.append(", geartype_cd=");
		builder.append(geartype_cd);
		builder.append(", consumed_gear=");
		builder.append(consumed_gear);
		builder.append(", desc=");
		builder.append(desc);
		builder.append(", insert_dt=");
		builder.append(insert_dt);
		builder.append(", update_dt=");
		builder.append(update_dt);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	

}
