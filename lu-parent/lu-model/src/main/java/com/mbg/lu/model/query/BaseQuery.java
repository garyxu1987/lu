package com.mbg.lu.model.query;

import java.io.Serializable;

import org.springframework.data.mongodb.core.query.Query;

public abstract class BaseQuery implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7308496120217425768L;

	public abstract Query getQuery();

}
