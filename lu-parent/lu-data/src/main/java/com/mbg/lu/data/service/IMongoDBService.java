package com.mbg.lu.data.service;

import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;

import com.mbg.lu.model.query.BaseQuery;

public interface IMongoDBService extends MongoOperations {

	public <T> T findOne(BaseQuery query, Class<T> entityClass);

	public <T> List<T> find(BaseQuery query, Class<T> entityClass);
}
