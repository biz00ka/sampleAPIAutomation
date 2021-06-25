package com.sample.api.Tests;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sample.api.action.SamplePojoAction;

import io.restassured.response.Response;




public class GetTestsSample 

{
	private SamplePojoAction spa;
	
	@BeforeClass
	public void init()
	{
		spa= new SamplePojoAction();
	}
	
    
	@Test
	public void test1()
	{
		System.out.println("Hello world..");
		Response res= spa.getListOfUsers();
		System.out.println(res.asPrettyString());
		Assert.assertEquals(res.getStatusCode(), HttpStatus.SC_OK,"Unable to find the User.");
	}
	
	
}
