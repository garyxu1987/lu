package com.mbg.lu.product.service.impl;

import java.io.Serializable;
import java.util.List;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.mbg.lu.data.service.IMongoDBService;
import com.mbg.lu.model.domain.product.Product;
import com.mbg.lu.model.domain.product.query.ProductQuery;
import com.mbg.lu.product.service.IProductManageService;

@Service(version = "1.0.0")
public class ProductManageServiceImpl implements IProductManageService {

	@Reference(version = "1.0.0")
	IMongoDBService mongoDBService;

	public void saveProduct(Product product) {
		mongoDBService.save(product);
	}

	public Product getProduct(Serializable id) {
		ProductQuery query = new ProductQuery();
		query.setProductId(id);
		return mongoDBService.findOne(query, Product.class);
	}

	@Override
	public List<Product> searchProduct(ProductQuery query) {
		return mongoDBService.find(query, Product.class);
	}

}
