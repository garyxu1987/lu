package com.mbg.lu.data.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.mongodb.core.CollectionCallback;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.DbCallback;
import org.springframework.data.mongodb.core.DocumentCallbackHandler;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.IndexOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ScriptOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.core.mapreduce.GroupBy;
import org.springframework.data.mongodb.core.mapreduce.GroupByResults;
import org.springframework.data.mongodb.core.mapreduce.MapReduceOptions;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.util.CloseableIterator;

import com.alibaba.dubbo.config.annotation.Service;
import com.mbg.lu.data.service.IMongoDBService;
import com.mbg.lu.model.query.BaseQuery;
import com.mongodb.CommandResult;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.ReadPreference;
import com.mongodb.WriteResult;

@Service(version = "1.0.0")
public class MongoDBServiceImpl implements IMongoDBService {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	MongoTemplate mongoTemplate;

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	@Override
	public String getCollectionName(Class<?> entityClass) {
		return this.getMongoTemplate().getCollectionName(entityClass);
	}

	@Override
	public CommandResult executeCommand(String jsonCommand) {
		return this.getMongoTemplate().executeCommand(jsonCommand);
	}

	@Override
	public CommandResult executeCommand(DBObject command) {
		return this.getMongoTemplate().executeCommand(command);
	}

	@SuppressWarnings("deprecation")
	@Override
	public CommandResult executeCommand(DBObject command, int options) {
		return this.getMongoTemplate().executeCommand(command, options);
	}

	@Override
	public CommandResult executeCommand(DBObject command,
			ReadPreference readPreference) {
		return this.getMongoTemplate().executeCommand(command, readPreference);
	}

	@Override
	public void executeQuery(Query query, String collectionName,
			DocumentCallbackHandler dch) {
		this.getMongoTemplate().executeQuery(query, collectionName, dch);
	}

	@Override
	public <T> T execute(DbCallback<T> action) {
		return this.getMongoTemplate().execute(action);
	}

	@Override
	public <T> T execute(Class<?> entityClass, CollectionCallback<T> action) {
		return this.getMongoTemplate().execute(entityClass, action);
	}

	@Override
	public <T> T execute(String collectionName, CollectionCallback<T> action) {
		return this.getMongoTemplate().execute(collectionName, action);
	}

	@SuppressWarnings("deprecation")
	@Override
	public <T> T executeInSession(DbCallback<T> action) {
		return this.getMongoTemplate().executeInSession(action);
	}

	@Override
	public <T> CloseableIterator<T> stream(Query query, Class<T> entityType) {
		return this.getMongoTemplate().stream(query, entityType);
	}

	@Override
	public <T> DBCollection createCollection(Class<T> entityClass) {
		return this.getMongoTemplate().createCollection(entityClass);
	}

	@Override
	public <T> DBCollection createCollection(Class<T> entityClass,
			CollectionOptions collectionOptions) {
		return this.getMongoTemplate().createCollection(entityClass,
				collectionOptions);
	}

	@Override
	public DBCollection createCollection(String collectionName) {
		return this.getMongoTemplate().createCollection(collectionName);
	}

	@Override
	public DBCollection createCollection(String collectionName,
			CollectionOptions collectionOptions) {
		return this.getMongoTemplate().createCollection(collectionName,
				collectionOptions);
	}

	@Override
	public Set<String> getCollectionNames() {
		return this.getMongoTemplate().getCollectionNames();
	}

	@Override
	public DBCollection getCollection(String collectionName) {
		return this.getMongoTemplate().getCollection(collectionName);
	}

	@Override
	public <T> boolean collectionExists(Class<T> entityClass) {
		return this.getMongoTemplate().collectionExists(entityClass);
	}

	@Override
	public boolean collectionExists(String collectionName) {
		return this.getMongoTemplate().collectionExists(collectionName);
	}

	@Override
	public <T> void dropCollection(Class<T> entityClass) {
		this.getMongoTemplate().dropCollection(entityClass);
	}

	@Override
	public void dropCollection(String collectionName) {
		this.getMongoTemplate().dropCollection(collectionName);
	}

	@Override
	public IndexOperations indexOps(String collectionName) {
		return this.getMongoTemplate().indexOps(collectionName);
	}

	@Override
	public IndexOperations indexOps(Class<?> entityClass) {
		return this.getMongoTemplate().indexOps(entityClass);
	}

	@Override
	public ScriptOperations scriptOps() {
		return this.getMongoTemplate().scriptOps();
	}

	@Override
	public <T> List<T> findAll(Class<T> entityClass) {
		return this.getMongoTemplate().findAll(entityClass);
	}

	@Override
	public <T> List<T> findAll(Class<T> entityClass, String collectionName) {
		return this.getMongoTemplate().findAll(entityClass, collectionName);
	}

	@Override
	public <T> GroupByResults<T> group(String inputCollectionName,
			GroupBy groupBy, Class<T> entityClass) {
		return this.getMongoTemplate().group(inputCollectionName, groupBy,
				entityClass);
	}

	@Override
	public <T> GroupByResults<T> group(Criteria criteria,
			String inputCollectionName, GroupBy groupBy, Class<T> entityClass) {
		return this.getMongoTemplate().group(criteria, inputCollectionName,
				groupBy, entityClass);
	}

	@Override
	public <O> AggregationResults<O> aggregate(TypedAggregation<?> aggregation,
			String collectionName, Class<O> outputType) {
		return this.getMongoTemplate().aggregate(aggregation, collectionName,
				outputType);
	}

	@Override
	public <O> AggregationResults<O> aggregate(TypedAggregation<?> aggregation,
			Class<O> outputType) {
		return this.getMongoTemplate().aggregate(aggregation, outputType);
	}

	@Override
	public <O> AggregationResults<O> aggregate(Aggregation aggregation,
			Class<?> inputType, Class<O> outputType) {
		return this.getMongoTemplate().aggregate(aggregation, inputType,
				outputType);
	}

	@Override
	public <O> AggregationResults<O> aggregate(Aggregation aggregation,
			String collectionName, Class<O> outputType) {
		return this.getMongoTemplate().aggregate(aggregation, collectionName,
				outputType);
	}

	@Override
	public <T> MapReduceResults<T> mapReduce(String inputCollectionName,
			String mapFunction, String reduceFunction, Class<T> entityClass) {
		return this.getMongoTemplate().mapReduce(inputCollectionName,
				mapFunction, reduceFunction, entityClass);
	}

	@Override
	public <T> MapReduceResults<T> mapReduce(String inputCollectionName,
			String mapFunction, String reduceFunction,
			MapReduceOptions mapReduceOptions, Class<T> entityClass) {
		return this.getMongoTemplate().mapReduce(inputCollectionName,
				mapFunction, reduceFunction, mapReduceOptions, entityClass);
	}

	@Override
	public <T> MapReduceResults<T> mapReduce(Query query,
			String inputCollectionName, String mapFunction,
			String reduceFunction, Class<T> entityClass) {
		return this.getMongoTemplate().mapReduce(query, inputCollectionName,
				mapFunction, reduceFunction, entityClass);
	}

	@Override
	public <T> MapReduceResults<T> mapReduce(Query query,
			String inputCollectionName, String mapFunction,
			String reduceFunction, MapReduceOptions mapReduceOptions,
			Class<T> entityClass) {
		return this.getMongoTemplate().mapReduce(query, inputCollectionName,
				mapFunction, reduceFunction, mapReduceOptions, entityClass);
	}

	@Override
	public <T> GeoResults<T> geoNear(NearQuery near, Class<T> entityClass) {
		return this.getMongoTemplate().geoNear(near, entityClass);
	}

	@Override
	public <T> GeoResults<T> geoNear(NearQuery near, Class<T> entityClass,
			String collectionName) {
		return this.getMongoTemplate().geoNear(near, entityClass,
				collectionName);
	}

	@Override
	public <T> T findOne(Query query, Class<T> entityClass) {
		return this.getMongoTemplate().findOne(query, entityClass);
	}

	@Override
	public <T> T findOne(Query query, Class<T> entityClass,
			String collectionName) {
		return this.getMongoTemplate().findOne(query, entityClass,
				collectionName);
	}

	@Override
	public boolean exists(Query query, String collectionName) {
		return this.getMongoTemplate().exists(query, collectionName);
	}

	@Override
	public boolean exists(Query query, Class<?> entityClass) {
		return this.getMongoTemplate().exists(query, entityClass);
	}

	@Override
	public boolean exists(Query query, Class<?> entityClass,
			String collectionName) {
		return this.getMongoTemplate().exists(query, entityClass,
				collectionName);
	}

	@Override
	public <T> List<T> find(Query query, Class<T> entityClass) {
		return this.getMongoTemplate().find(query, entityClass);
	}

	@Override
	public <T> List<T> find(Query query, Class<T> entityClass,
			String collectionName) {
		return this.getMongoTemplate().find(query, entityClass, collectionName);
	}

	@Override
	public <T> T findById(Object id, Class<T> entityClass) {
		return this.getMongoTemplate().findById(id, entityClass);
	}

	@Override
	public <T> T findById(Object id, Class<T> entityClass, String collectionName) {
		return this.getMongoTemplate()
				.findById(id, entityClass, collectionName);
	}

	@Override
	public <T> T findAndModify(Query query, Update update, Class<T> entityClass) {
		return this.getMongoTemplate()
				.findAndModify(query, update, entityClass);
	}

	@Override
	public <T> T findAndModify(Query query, Update update,
			Class<T> entityClass, String collectionName) {
		return this.getMongoTemplate().findAndModify(query, update,
				entityClass, collectionName);
	}

	@Override
	public <T> T findAndModify(Query query, Update update,
			FindAndModifyOptions options, Class<T> entityClass) {
		return this.getMongoTemplate().findAndModify(query, update, options,
				entityClass);
	}

	@Override
	public <T> T findAndModify(Query query, Update update,
			FindAndModifyOptions options, Class<T> entityClass,
			String collectionName) {
		return this.getMongoTemplate().findAndModify(query, update, options,
				entityClass, collectionName);
	}

	@Override
	public <T> T findAndRemove(Query query, Class<T> entityClass) {
		return this.getMongoTemplate().findAndRemove(query, entityClass);
	}

	@Override
	public <T> T findAndRemove(Query query, Class<T> entityClass,
			String collectionName) {
		return this.getMongoTemplate().findAndRemove(query, entityClass,
				collectionName);
	}

	@Override
	public long count(Query query, Class<?> entityClass) {
		return this.getMongoTemplate().count(query, entityClass);
	}

	@Override
	public long count(Query query, String collectionName) {
		return this.getMongoTemplate().count(query, collectionName);
	}

	@Override
	public long count(Query query, Class<?> entityClass, String collectionName) {
		return this.getMongoTemplate()
				.count(query, entityClass, collectionName);
	}

	@Override
	public void insert(Object objectToSave) {
		this.getMongoTemplate().insert(objectToSave);
	}

	@Override
	public void insert(Object objectToSave, String collectionName) {
		this.getMongoTemplate().insert(objectToSave, collectionName);
	}

	@Override
	public void insert(Collection<? extends Object> batchToSave,
			Class<?> entityClass) {
		this.getMongoTemplate().insert(batchToSave, entityClass);
	}

	@Override
	public void insert(Collection<? extends Object> batchToSave,
			String collectionName) {
		this.getMongoTemplate().insert(batchToSave, collectionName);
	}

	@Override
	public void insertAll(Collection<? extends Object> objectsToSave) {
		this.getMongoTemplate().insertAll(objectsToSave);
	}

	@Override
	public void save(Object objectToSave) {
		this.getMongoTemplate().save(objectToSave);
	}

	@Override
	public void save(Object objectToSave, String collectionName) {
		this.getMongoTemplate().save(objectToSave, collectionName);
	}

	@Override
	public WriteResult upsert(Query query, Update update, Class<?> entityClass) {
		return this.getMongoTemplate().upsert(query, update, entityClass);
	}

	@Override
	public WriteResult upsert(Query query, Update update, String collectionName) {
		return this.getMongoTemplate().upsert(query, update, collectionName);
	}

	@Override
	public WriteResult upsert(Query query, Update update, Class<?> entityClass,
			String collectionName) {
		return this.getMongoTemplate().upsert(query, update, entityClass,
				collectionName);
	}

	@Override
	public WriteResult updateFirst(Query query, Update update,
			Class<?> entityClass) {
		return this.getMongoTemplate().updateFirst(query, update, entityClass);
	}

	@Override
	public WriteResult updateFirst(Query query, Update update,
			String collectionName) {
		return this.getMongoTemplate().updateFirst(query, update,
				collectionName);
	}

	@Override
	public WriteResult updateFirst(Query query, Update update,
			Class<?> entityClass, String collectionName) {
		return this.getMongoTemplate().updateFirst(query, update, entityClass,
				collectionName);
	}

	@Override
	public WriteResult updateMulti(Query query, Update update,
			Class<?> entityClass) {
		return this.getMongoTemplate().updateMulti(query, update, entityClass);
	}

	@Override
	public WriteResult updateMulti(Query query, Update update,
			String collectionName) {
		return this.getMongoTemplate().updateMulti(query, update,
				collectionName);
	}

	@Override
	public WriteResult updateMulti(Query query, Update update,
			Class<?> entityClass, String collectionName) {
		return this.getMongoTemplate().updateMulti(query, update, entityClass,
				collectionName);
	}

	@Override
	public WriteResult remove(Object object) {
		return this.getMongoTemplate().remove(object);
	}

	@Override
	public WriteResult remove(Object object, String collection) {
		return this.getMongoTemplate().remove(object, collection);
	}

	@Override
	public WriteResult remove(Query query, Class<?> entityClass) {
		return this.getMongoTemplate().remove(query, entityClass);
	}

	@Override
	public WriteResult remove(Query query, Class<?> entityClass,
			String collectionName) {
		return this.getMongoTemplate().remove(query, entityClass,
				collectionName);
	}

	@Override
	public WriteResult remove(Query query, String collectionName) {
		return this.getMongoTemplate().remove(query, collectionName);
	}

	@Override
	public <T> List<T> findAllAndRemove(Query query, String collectionName) {
		return this.getMongoTemplate().findAllAndRemove(query, collectionName);
	}

	@Override
	public <T> List<T> findAllAndRemove(Query query, Class<T> entityClass) {
		return this.getMongoTemplate().findAllAndRemove(query, entityClass);
	}

	@Override
	public <T> List<T> findAllAndRemove(Query query, Class<T> entityClass,
			String collectionName) {
		return this.getMongoTemplate().findAllAndRemove(query, entityClass,
				collectionName);
	}

	@Override
	public MongoConverter getConverter() {
		return this.getMongoTemplate().getConverter();
	}

	// ****************custom method below
	@Override
	public <T> T findOne(BaseQuery query, Class<T> entityClass) {
		return this.findOne(query.getQuery(), entityClass);
	}

	@Override
	public <T> List<T> find(BaseQuery query, Class<T> entityClass) {
		return this.find(query.getQuery(), entityClass);
	}

}
