/**
 * copyright kikimans
 * @Project     : megapaas
 * 
 */
package kr.jyes.megapaas.repository;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import kr.jyes.megapaas.model.CommonCode;

/**
 * <pre>
 * kr.jyes.megapaas.repository
 *   |_ CodeRepository.java
 *
 * <pre>
 * 
 * 
 * @Date         : 2014. 10. 28. 
 * @작성자      : kikimans
 * @변경이력 :
 * @프로그램 설명 : 공통코드 Repository
 */
@Repository
public class CodeRepository implements ICodeRepository {

	private static final Logger logger = LoggerFactory.getLogger(CodeRepository.class);
	private static final String COLLECTION_NAME = "code";
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	/**
	 * 
	 */
	public CodeRepository() {
		// TODO Auto-generated constructor stub
		
	}

	

	/* (non-Javadoc)
	 * @see kr.jyes.megapaas.repository.ICodeRepository#listCode()
	 */
	@Override
	public List<CommonCode> listCode() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see kr.jyes.megapaas.repository.ICodeRepository#createCode(kr.jyes.megapaas.model.CommonCode)
	 */
	@Override
	public void createCode(CommonCode code) {
		// TODO Auto-generated method stub
		if(code != null){
			mongoTemplate.save(code, COLLECTION_NAME);
		}
	}

	/* (non-Javadoc)
	 * @see kr.jyes.megapaas.repository.ICodeRepository#deleteCode(kr.jyes.megapaas.model.CommonCode)
	 */
	@Override
	public void deleteCode(CommonCode cd) {
		// TODO Auto-generated method stub

	}



	@Override
	public int updateCode(CommonCode code) {
		// TODO Auto-generated method stub
		try {
			if(code !=null){
				code.setUpdate_dt(new Date());
				mongoTemplate.save(code);
				return 0;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			return 1;
		}
		return 1;
	}



	

}
