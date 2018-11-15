package com.cs.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cs.qa.base.TestBase;

public class SignUpPage extends TestBase {

	@FindBy(id = "user[login]")
	WebElement userName;

	@FindBy(id = "user[email]")
	WebElement email;

	@FindBy(id = "user[password]")
	WebElement password;

	@FindBy(xpath = "//button[contains(text(),'Sign up for GitHub')]")
	WebElement signupButton;

	public SignUpPage() {

		PageFactory.initElements(driver, this);

	}

	public void SignUp() {

		userName.sendKeys("email@email.com");
		signupButton.click();

	}

}
