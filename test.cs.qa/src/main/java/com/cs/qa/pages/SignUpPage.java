package com.cs.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

	@FindBy(xpath = "//div[contains(@class,'flash flash-error my-3')]")
	WebElement mainError;

	@FindBy(xpath = "//dd[contains(@class,'error')]")
	WebElement erros;

	public SignUpPage() {

		PageFactory.initElements(driver, this);

	}

	public String SignUp(String fMail, String fUname, String fPassword) throws InterruptedException {

		userName.sendKeys(fUname);
		email.sendKeys(fMail);
		password.sendKeys(fPassword);

		signupButton.click();
		Thread.sleep(2000);
		String Error = mainError.getText();
		// List<WebElement> erros =
		// driver.findElements(By.xpath("//dd[contains(@class,'error')]"));
		return Error;

	}

	public List pageValidation(String fMail, String fUname) {

		userName.clear();
		userName.sendKeys(fUname);

		email.clear();
		email.sendKeys(fMail);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.visibilityOf(erros));
		List<WebElement> erros = driver.findElements(By.xpath("//dd[contains(@class,'error')]"));
		System.out.println((erros.get(0)).getText());
		System.out.println(erros.size());
		return erros;

	}

	public List<WebElement> SignUp_password(String fMail, String fUname, String fPassword) throws InterruptedException {

		userName.sendKeys(fUname);
		email.sendKeys(fMail);
		password.sendKeys(fPassword);

		signupButton.click();
		Thread.sleep(2000);
		String Error = mainError.getText();
		List<WebElement> erros = driver.findElements(By.xpath("//dd[contains(@class,'error')]"));
		return erros;

	}

}
