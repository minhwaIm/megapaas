/**
 * 
 */
package kr.jyes.megapaas.model;

import java.io.Serializable;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
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
 * CommonCode.java
 * </pre>
 *
 * @author  : kikimans
 * @Date    : 2014. 10. 27.
 * @Version : 
 */
@Document(collection="code")
public class CommonCode extends AbstractObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int code;
	private String value;
	private String name;
	private String desc;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date insert_dt;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date update_dt;
	private String useYn;
	private String register;
	
	public CommonCode(){
		this(new Date());
	}


	public CommonCode(Date date) {
		// TODO Auto-generated constructor stub
		this.insert_dt = date;
	}
	
	
	
	
	/**
	 * @param code
	 * @param value
	 * @param name
	 * @param desc
	 * @param register
	 */
	public CommonCode(int code, String value, String name, String desc,
			String register) {
		super();
		this.code = code;
		this.value = value;
		this.name = name;
		this.desc = desc;
		this.register = register;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
	}	
	
	/*
	 * 2014.10.27 add code value 
	 */
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CommonCode [code=");
		builder.append(code);
		builder.append(", value=");
		builder.append(value);
		builder.append(", name=");
		builder.append(name);
		builder.append(", desc=");
		builder.append(desc);
		builder.append(", insert_dt=");
		builder.append(insert_dt);
		builder.append(", update_dt=");
		builder.append(update_dt);
		builder.append(", useYn=");
		builder.append(useYn);
		builder.append(", register=");
		builder.append(register);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	

}
