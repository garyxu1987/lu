package com.mbg.lu.product;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:spring/applicationContext.xml" });
		context.start();

		System.in.read(); //等待键盘输入停止

		context.close();
	}

}