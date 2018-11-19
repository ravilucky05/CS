package com.csapi.test.tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APITests {

	String rest = "https://api.github.com/";

	@Test
	public void Get_current_version() {
		RestAssured.baseURI = rest;
		RequestSpecification httprequest = RestAssured.given();
		httprequest.header("Accept", "application/vnd.github.v3+json");

		Response response = httprequest.get("/");
		System.out.println(response.getBody().asString());
	}

	@Test
	public void Get_schema() {
		RestAssured.baseURI = rest;
		RequestSpecification httprequest = RestAssured.given();
		httprequest.header("Accept", "application/vnd.github.v3+json");

		Response response = httprequest.get("users/octocat/orgs");
		System.out.println(response.getHeaders().asList());
	}

	@Test
	public void Get_summary() {
		RestAssured.baseURI = rest;
		RequestSpecification httprequest = RestAssured.given();
		httprequest.header("Accept", "application/vnd.github.v3+json");

		Response response = httprequest.get("/orgs/octokit/repos");
		System.out.println(response.getBody().asString());
	}
}
