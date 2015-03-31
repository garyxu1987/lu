package com.mbg.lu.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mbg.lu.model.domain.product.query.ProductQuery;
import com.mbg.lu.product.service.IProductManageService;

@Controller
@RequestMapping("home")
public class HomeController {

	@Autowired
	IProductManageService productManageService;

	@RequestMapping("hw")
	@ResponseBody
	public Object helloWorld() {
		return productManageService.searchProduct(new ProductQuery());
	}
}
