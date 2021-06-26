package com.iNetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  {
	WebDriver driver;
	
	
	
	
	public LoginPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		driver = driver2;
		PageFactory.initElements(driver2, this);
	}

	@FindBy(name="uid")
	@CacheLookup
	WebElement username;
	
	
	@FindBy(xpath="//input[@type='password']")
	@CacheLookup
	WebElement password;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement loginBtn;
	
	@FindBy(name="btnReset")
	@CacheLookup
	WebElement resetBtn;
	
	public String validateTitle()
	{
		return driver.getTitle();
	}
	
	
	public void sendUserName(String user)
	{
		username.sendKeys(user);
	}
	
	public void sendPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickOnLoginBtn()
	{
		loginBtn.click();
	}
	public void clickOnResetBtn()
	{
		resetBtn.click();
	}
	
	public void doLoginMethod(String user, String pass)
	{
		username.sendKeys(user);
		password.sendKeys(pass);
		loginBtn.click();
	}

}