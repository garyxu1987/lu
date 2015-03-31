package com.mbg.lu.model.domain.product;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8881971040038675612L;

	@Id
	private String productId;
	private String productName;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}
