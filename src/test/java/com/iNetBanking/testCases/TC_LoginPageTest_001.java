package com.iNetBanking.testCases;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.iNetBanking.pageObjects.LoginPage;

import com.iNetBanking.utilities.BasicUtilityFiles;

public class TC_LoginPageTest_001 extends BaseClassTest{
	
	LoginPage lp;

	
	
	
	@Test
	public void loginTest()
	{
		
		lp = new LoginPage(driver);
		lp.sendUserName(prop.getProperty("username"));
		logger.info("User name is entered");
		lp.sendPassword(prop.getProperty("password"));
		logger.info("Password is entered");
		lp.clickOnLoginBtn();
		logger.info("User clicks on Login Btn");
		
		String ACTUAL_TITLE_OF_PAGE = lp.validateTitle();
		Assert.assertEquals(BasicUtilityFiles.TITLE_OF_DASHBOARD_PAGE, ACTUAL_TITLE_OF_PAGE);
		logger.info("Validating the title of the page");
		captureScreenshot(driver, "loginTest");
		
	}
	

}
