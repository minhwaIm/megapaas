import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import kr.jyes.megapaas.model.AppTag;
import kr.jyes.megapaas.repository.AppTagRepository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.openshift.client.IOpenShiftConnection;
import com.openshift.client.OpenShiftConnectionFactory;
import com.openshift.client.cartridge.IStandaloneCartridge;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { 
"file:src/main/webapp/WEB-INF/config/spring/application-servlet.xml",
"file:src/main/resources/spring/context-root.xml"})
public class testinitData {

	private String serverUrl;
	private String clientId;
	
	private IOpenShiftConnection connection;
	
	@Autowired AppTagRepository appTagRepo;

	@Before
	public void setUp() throws Exception {
		serverUrl = "broker-test.ucareme.co.kr";
		clientId = "megapaas-service";
		connection = new OpenShiftConnectionFactory().getConnection(clientId, "kikimans@gmail.com", "alsgh@1716", serverUrl);
	}

	@Test
	public void test_application_initData() {
		List<IStandaloneCartridge> standaloneCarts = connection.getStandaloneCartridges();
		
		String[] javanames = {"jyes-egovframework-3.0","jbosseap-6","jbossews-2.0", "jbossews-1.0"};
		String[] phpnames = {"php-5.3"};
		String[] nodejsnames = {"nodejs-0.10"};
		String[] rubynames = {"ruby-1.9","ruby-1.8"};
		String[] pythonnames = {"python-2.7","python-2.6"};
		String[] instancennames = {"jenkins-1"};
		String[] diynames = {"diy-0.1"};
		String[] perlnames = {"perl-5.10"};
		
		
		List<AppTag> tags = new ArrayList<AppTag>();
		
		for(IStandaloneCartridge icart : standaloneCarts){
			AppTag tag = new AppTag();
			if(getArray(javanames).contains(icart.getName())){
				tag.setTag("java");
				tag.setType("standalone");
				tag.setStandloneCart(icart);
			}else if(getArray(phpnames).contains(icart.getName())){
				tag.setTag("php");
				tag.setType("standalone");
				tag.setStandloneCart(icart);
			}else if(getArray(nodejsnames).contains(icart.getName())){
				tag.setTag("nodejs");
				tag.setType("standalone");
				tag.setStandloneCart(icart);
			}else if(getArray(rubynames).contains(icart.getName())){
				tag.setTag("ruby");
				tag.setType("standalone");
				tag.setStandloneCart(icart);
			}else if(getArray(pythonnames).contains(icart.getName())){
				tag.setTag("python");
				tag.setType("standalone");
				tag.setStandloneCart(icart);
			}else if(getArray(instancennames).contains(icart.getName())){
				tag.setTag("instance_app");
				tag.setType("standalone");
				tag.setStandloneCart(icart);
			}else if(getArray(diynames).contains(icart.getName())){
				tag.setTag("diy");
				tag.setType("standalone");
				tag.setStandloneCart(icart);
			}else if(getArray(perlnames).contains(icart.getName())){
				tag.setTag("perl");
				tag.setType("standalone");
				tag.setStandloneCart(icart);
			}
			
			tags.add(tag);
		}
		appTagRepo.save(tags);
		
	}
	
	public List<String> getArray(String[] names){
		List<String> arrayNames = new ArrayList<String>();
		
		for(String name : names){
			arrayNames.add(name);
		}
		
		return arrayNames;
	}

}
