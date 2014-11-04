package kr.jyes.megapaas.repository;

import kr.jyes.megapaas.model.AppTag;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
public interface AppTagRepository extends MongoRepository<AppTag, ObjectId> {

}
