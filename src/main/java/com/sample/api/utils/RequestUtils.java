package com.sample.api.utils;

import java.util.Map;

import com.sample.api.constants.Endpoint;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RequestUtils {
	
	
	public RequestUtils()
	{
		RestAssured.baseURI=ConfigUtils.getConfigInstance().getKeyValueOf("base_url");
	}
	
	public Response getRequest(String endPoint)
	{
		Response res= RestAssured
				.given()
				.contentType(ContentType.JSON)
				.get(endPoint)
				.andReturn();
		
		return res;
	}
	
	public Response getRequestWithParam(String endPoint, Map<String,String> params)
	{
		Response res= RestAssured
				.given()
				.contentType(ContentType.JSON)
				.queryParams(params)
				.get(endPoint)
				.andReturn();
		
		return res;
	}
	
	public Response getRequestWithHeader(String endPoint, Map<String,String> header)
	{
		Response res= RestAssured
				.given()
				.contentType(ContentType.JSON)
				.headers(header)
				.get(endPoint)
				.andReturn();
		
		return res;
	}
	
	public Response getRequestWithHeaderAndParamss(String endPoint, Map<String,String> header, Map<String,String> params)
	{
		Response res= RestAssured
				.given()
				.contentType(ContentType.JSON)
				.headers(header)
				.queryParams(params)
				.get(endPoint)
				.andReturn();
		
		return res;
	}
	

}
