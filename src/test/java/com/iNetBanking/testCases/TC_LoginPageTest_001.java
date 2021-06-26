package com.iNetBanking.testCases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iNetBanking.pageObjects.LoginPage;
import com.iNetBanking.utilities.BasicUtilityFiles;

public class TC_LoginPageTest_001 extends BaseClassTest{
	
	LoginPage lp;
	
	public TC_LoginPageTest_001()
	{
		//Calling constructor of super class
		super();
	}
	
	
	@BeforeMethod
	public void setUp()
	{
		browserInvoke();
		
		lp = new LoginPage(driver);
	}
	@Test
	public void validateTitle()
	{
		System.out.println("Hello");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
