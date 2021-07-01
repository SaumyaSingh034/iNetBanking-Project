package com.iNetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name = "uid")
	@CacheLookup
	WebElement username;

	@FindBy(xpath = "//input[@type='password']")
	@CacheLookup
	WebElement password;

	@FindBy(name = "btnLogin")
	@CacheLookup
	WebElement loginBtn;

	@FindBy(name = "btnReset")
	@CacheLookup
	WebElement resetBtn;

	public String validateTitle() {
		return ldriver.getTitle();
	}

	public void sendUserName(String user) {
		username.sendKeys(user);
	}

	public void sendPassword(String pass) {
		password.sendKeys(pass);
	}

	public void clickOnLoginBtn() {
		loginBtn.click();
	}

	public void clickOnResetBtn() {
		resetBtn.click();
	}

	public HomePage doLoginMethod(String user, String pass) throws InterruptedException {
		
		username.sendKeys(user);
		Thread.sleep(4000);
		password.sendKeys(pass);
		Thread.sleep(4000);
		loginBtn.click();
		
		Thread.sleep(4000);
		return new HomePage(ldriver);
	}

}
