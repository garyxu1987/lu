package com.mbg.lu.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestMongoDBService extends MongoDBService {

	Logger logger = LoggerFactory.getLogger(getClass());

	public void save(Object obj) {
		getMongoTemplate().save(obj);
	}

}
