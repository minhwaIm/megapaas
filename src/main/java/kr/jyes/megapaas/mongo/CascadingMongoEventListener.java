/**
 * 
 */
package kr.jyes.megapaas.mongo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mapping.model.MappingException;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
/**
 * <pre>
 * kr.jyes.megapaas.mongo
 * CascadingMongoEventListener.java
 * OpenSource 에서 찾아서 추가 한 내용임
 * </pre>
 *
 * @author  : kikimans
 * @Date    : 2014. 11. 4.
 * @Version : 
 */
@Component
public class CascadingMongoEventListener extends AbstractMongoEventListener {

	@Autowired
    private MongoTemplate MongoTemplate;
 
    @Override
    public void onBeforeConvert(final Object source) {
        ReflectionUtils.doWithFields(source.getClass(), new ReflectionUtils.FieldCallback() {
 
            public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                ReflectionUtils.makeAccessible(field);
 
                if (field.isAnnotationPresent(DBRef.class) && field.isAnnotationPresent(CascadeSave.class)) {
                    final Object fieldValue = field.get(source);
 
                    DbRefFieldCallback callback = new DbRefFieldCallback();
 
                    ReflectionUtils.doWithFields(fieldValue.getClass(), callback);
 
                    if (!callback.isIdFound()) {
                        throw new MappingException("Cannot perform cascade save on child object without id set");
                    }
 
                    MongoTemplate.save(fieldValue);
                }
            }

			
        });
    }
 
    private static class DbRefFieldCallback implements ReflectionUtils.FieldCallback {
        private boolean idFound;
 
        public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
            ReflectionUtils.makeAccessible(field);
 
            if (field.isAnnotationPresent(Id.class)) {
                idFound = true;
            }
        }
 
        public boolean isIdFound() {
            return idFound;
        }
    }
}
