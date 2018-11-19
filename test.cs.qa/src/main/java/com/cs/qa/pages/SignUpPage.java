package com.cs.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cs.qa.base.TestBase;

public class SignUpPage extends TestBase {

	@FindBy(name = "user[login]")
	WebElement userName;

	@FindBy(name = "user[email]")
	WebElement email;

	@FindBy(name = "user[password]")
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

		driver.get("https://github.com/");
		userName.clear();
		userName.sendKeys(fUname);
		email.clear();
		email.sendKeys(fMail);
		password.clear();
		password.sendKeys(fPassword);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		signupButton.click();
		// js.executeScript("arguments[0].scrollIntoView();", password);

		js.executeScript("window.scrollBy(0,500)");

		// String Error = mainError.getText();
		List<WebElement> erros = driver.findElements(By.xpath("//dd[contains(@class,'error')]"));
		Thread.sleep(2000);
		// driver.navigate().back();
		return erros;

	}

	public void userValidation() {

		userName.clear();
		String s = "!@#$%^&*()";
		List results = null;
		String Error = "Username may only contain alphanumeric characters or single hyphens, and cannot begin or end with a hyphen";
		for (int i = 0; i < s.length(); i++) {
			String u = s.charAt(i) + "test";
			userName.clear();
			userName.sendKeys(u);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			WebDriverWait wait = new WebDriverWait(driver, 3000);
			wait.until(ExpectedConditions.visibilityOf(erros));
			List<WebElement> erros = driver.findElements(By.xpath("//dd[contains(@class,'error')]"));

			String UE = erros.get(0).getText();

			if (!Error.equals(UE)) {

				System.out.println("acceoted specual charter");

			}

		}

	}

}
