package com.mbg.lu.model.query;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class ProductQuery extends BaseQuery {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6417220772910521534L;

	private String productName;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public Query getQuery() {
		return new Query(Criteria.where("productName").is(getProductName()));
	}

}
