package kr.jyes.megapaas.openshift;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.openshift.client.IOpenShiftConnection;
import com.openshift.client.OpenShiftConnectionFactory;
import com.openshift.client.cartridge.IStandaloneCartridge;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
public class ApplicationTest {
	
	private String serverUrl;
	private String clientId;
	
	private IOpenShiftConnection connection;

	@Before
	public void setUp() throws Exception {
		serverUrl = "broker-test.ucareme.co.kr";
		clientId = "megapaas-service";
		connection = new OpenShiftConnectionFactory().getConnection(clientId, "kikimans@gmail.com", "alsgh@1716", serverUrl);
	}

	@Test
	public void test_broker_connection() {		
		assertThat(connection, is(notNullValue()));
	}
	
	
	
	@Test
	public void test_broker_Avaial_Application(){
		 List<IStandaloneCartridge> standaloneCarts = connection.getStandaloneCartridges();
		 
		 for(IStandaloneCartridge cart : standaloneCarts){
			 
		 }
		 
		 IApplicationTag tag = new ApplicationTag();
		 
	}

}
