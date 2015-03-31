package com.mbg.lu.product.service.impl;

import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mbg.lu.data.service.IMongoDBService;
import com.mbg.lu.model.domain.product.Product;
import com.mbg.lu.model.query.ProductQuery;
import com.mbg.lu.product.service.IProductManageService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml",
		"classpath:dubbo-consumer.xml" })
public class ProductManageServiceImplTest {
	@Reference(version = "1.0.0")
	IProductManageService productManageService;
	@Reference(version = "1.0.0")
	IMongoDBService mongoDBService;

	@Test
	public void testSaveProduct() {
		// mongoDBService.dropCollection(Product.class);
		Product product = new Product();
		product.setProductName("test");
		productManageService.saveProduct(product);

		ProductQuery pq = new ProductQuery();
		pq.setProductName("test");
		assertNotNull(mongoDBService.findOne(pq, Product.class));
	}

	@Test
	public void testSearchProduct() {
		Product product = new Product();
		product.setProductName("test");
		productManageService.saveProduct(product);

		ProductQuery pq = new ProductQuery();
		pq.setProductName("test");
		Assert.assertNotEquals(productManageService.searchProduct(pq).size(), 0);
	}
}
