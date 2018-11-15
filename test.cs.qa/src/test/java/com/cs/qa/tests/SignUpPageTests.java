package com.cs.qa.tests;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.cs.qa.base.TestBase;
import com.cs.qa.pages.HomePage;
import com.cs.qa.pages.SignUpPage;

public class SignUpPageTests extends TestBase {

	HomePage homePage;
	SignUpPage signupPage;

	public SignUpPageTests() {
		super();
	}

	@BeforeSuite
	public void setUp() throws IOException {
		initialization();

		signupPage = new SignUpPage();

	}

	@Test
	public void test() {
		signupPage.SignUp();

	}

	@AfterSuite
	public void TearDown() {
		driver.quit();
	}

}
