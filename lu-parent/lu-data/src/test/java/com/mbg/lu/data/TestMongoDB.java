package com.mbg.lu.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class TestMongoDB {
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	TestMongoDBService mongoDBService;

	@Test
	public void testConnect() {
		TestObject to = new TestObject();
		to.setId(1);
		to.setName("n1");

		mongoDBService.save(to);

		System.out.println(mongoDBService
				.getMongoTemplate()
				.findOne(new Query(Criteria.where("name").is("n1")),
						TestObject.class).getName());
	}
}

class TestObject {
	private Integer id;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}