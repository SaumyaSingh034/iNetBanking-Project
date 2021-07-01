package com.iNetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver ldriver;
	
	@FindBy (xpath="//*[text()='Log out']")
	@CacheLookup
	WebElement logOutBtn;
	
	
	public HomePage(WebDriver hdriver)
	{
		ldriver = hdriver;
		PageFactory.initElements(hdriver, this);
	}
	
	public void clcikOnLogout()
	{
		logOutBtn.click();
	}
	
	
	
	
	

}
