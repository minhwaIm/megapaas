/**
 * 
 */
package kr.jyes.megapaas.model;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.openshift.client.cartridge.IEmbeddableCartridge;
import com.openshift.client.cartridge.IStandaloneCartridge;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
/**
 * <pre>
 * kr.jyes.megapaas.model
 * AppTag.java
 * </pre>
 *
 * @author  : kikimans
 * @Date    : 2014. 11. 4.
 * @Version : 
 */
@Document(collection="apptag")
public class AppTag extends AbstractMegaObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String tag;
	private String type;
	
	private IStandaloneCartridge StandloneCart;
	private IEmbeddableCartridge embeddableCart;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date insert_dt;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date update_dt;
	private String useYn;
	private String register; 

	/**
	 * @param objectId
	 */
	public AppTag(ObjectId objectId) {
		super(objectId);
		// TODO Auto-generated constructor stub
	}

	public AppTag() {
		// TODO Auto-generated constructor stub
		this(new ObjectId());
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public IStandaloneCartridge getStandloneCart() {
		return StandloneCart;
	}

	public void setStandloneCart(IStandaloneCartridge standloneCart) {
		StandloneCart = standloneCart;
	}

	public IEmbeddableCartridge getEmbeddableCart() {
		return embeddableCart;
	}

	public void setEmbeddableCart(IEmbeddableCartridge embeddableCart) {
		this.embeddableCart = embeddableCart;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AppTag [tag=");
		builder.append(tag);
		builder.append(", type=");
		builder.append(type);
		builder.append(", StandloneCart=");
		builder.append(StandloneCart);
		builder.append(", embeddableCart=");
		builder.append(embeddableCart);
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
