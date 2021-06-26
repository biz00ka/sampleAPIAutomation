package com.sample.api.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sample.api.constants.Endpoint;
import com.sample.api.pojos.User;
import com.sample.api.utils.ConfigUtils;
import com.sample.api.utils.RequestUtils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SamplePojoAction {
	
	private RequestUtils req;
	private String endPoint;
	
	public SamplePojoAction()
	{
		req= new RequestUtils();		
	}
		
	public Response getListOfUsers()
	{
		endPoint= Endpoint.GET_USERS;
		Map<String, String> params= new HashMap<String, String>();
		params.put("page","2");
		Response res=req.getRequestWithParam(endPoint, params);
		
		return res;
		
	}
	
	
	public Response postCreateUser()
	{
		endPoint=Endpoint.POST_CREATE_USERS;
		User user= new User();
		user.setName("Test Data One");
		user.setJob("Mechanic");
		Response res= req.postRequest(endPoint, user);
		return res;
	}
	
	
}
