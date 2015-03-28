package com.mbg.lu.product.service;

import com.mbg.lu.product.domain.Product;

public interface IProductManageService {

	public Integer saveProduct(Product product);

	public Product getProduct(Integer id);

}
