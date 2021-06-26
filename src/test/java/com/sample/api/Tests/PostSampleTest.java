package com.sample.api.Tests;

import org.testng.annotations.Test;

import com.sample.api.action.SamplePojoAction;

import io.restassured.response.Response;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class PostSampleTest {

	private SamplePojoAction spa;

	@BeforeClass
	public void init()
	{
		spa= new SamplePojoAction();
	}



	@Test
	public void postSampleTestWithBody() {
		
		System.out.println("Hello world..POST Req");
		Response res= spa.postCreateUser();
		System.out.println(res.asPrettyString());
		String id=res.jsonPath().getString("id");
		Assert.assertEquals(res.getStatusCode(), HttpStatus.SC_CREATED,"Unable to Create the User.");
		Assert.assertNotNull(id, "ID of newlly created User is NULL.");
	}

}
