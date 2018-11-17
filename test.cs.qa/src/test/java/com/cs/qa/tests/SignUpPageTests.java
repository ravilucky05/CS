package com.cs.qa.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
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

	// @Test
	public void test_invalid_username() throws InterruptedException {
		String Error = signupPage.SignUp("test", "", "");
		Assert.assertEquals(Error, "There were problems creating your account.");

	}

	@Test(priority = 1)
	public void test_invalid_uname() {
		// mail,username
		List Uerror = signupPage.pageValidation("", "test");
		Assert.assertEquals(((WebElement) Uerror.get(0)).getText(), "Username is already taken");
	}

	@Test(priority = 2)
	public void test_invalid_email() throws InterruptedException {

		List Uerror = signupPage.pageValidation("test@test.com", "");
		Assert.assertEquals(((WebElement) Uerror.get(0)).getText(), "Email is invalid or already taken");
	}

	@AfterSuite
	public void TearDown() {
		driver.quit();
	}

}
