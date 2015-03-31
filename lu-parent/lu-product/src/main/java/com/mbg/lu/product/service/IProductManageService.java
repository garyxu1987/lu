package com.mbg.lu.product.service;

import java.io.Serializable;
import java.util.List;

import com.mbg.lu.model.domain.product.Product;
import com.mbg.lu.model.query.ProductQuery;

public interface IProductManageService {

	public void saveProduct(Product product);

	public Product getProduct(Serializable id);

	public List<Product> searchProduct(ProductQuery query);

}
