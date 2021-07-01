package com.iNetBanking.testCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.iNetBanking.pageObjects.HomePage;
import com.iNetBanking.pageObjects.LoginPage;
import com.iNetBanking.utilities.XLUtils;

public class TC_LoginPage_DDT_002 extends BaseClassTest {
	
	LoginPage lp;
	HomePage hp;
	
	
	@Test(dataProvider = "LoginDataWithDataProvider")
	public void loginDDT(String user, String pwd)
	{
		lp = new LoginPage(driver);
		try {
			logger.info("User name is being enterted");
			logger.info("Password is being enterted");
			logger.info("User is going to click on Login Button");
			Thread.sleep(5000);
			hp = lp.doLoginMethod(user, pwd);
			System.out.println("UserName ---> "+user);
			System.out.println("Password ----> "+pwd);
			
			
			
			if(isAlertExits()==true)
			{
				logger.warn("Seems like you have used invalid data");
				Thread.sleep(5000);
				driver.switchTo().alert().accept(); //close alert
				logger.warn("Accepting the alert");
				Thread.sleep(5000);
				driver.switchTo().defaultContent();
				Assert.assertTrue(false);
				
			}
			else
			{
				Assert.assertTrue(true);
				logger.info("User is going to click on Logout Button");
				Thread.sleep(5000);
				hp.clcikOnLogout();
				logger.info("User successfully get logged out");
				Thread.sleep(5000);
				driver.switchTo().alert().accept(); //close alert
				Thread.sleep(5000);
				driver.switchTo().defaultContent();
				
			}
		} catch (InterruptedException e) {
	
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="LoginDataWithDataProvider")
	public String[][] getData() throws IOException
	{
		String path = "D:\\Selenium\\FrameworkPractice\\INetBanking\\testData\\testData.xlsx";
		int rowNum  = XLUtils.getRowCount(path, "LoginData");
		int colCount = XLUtils.getCellCount(path, "LoginData", 1);
		String loginData[][] = new String[rowNum][colCount];
		
		for(int i=1;i<=rowNum;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				loginData[i-1][j] = XLUtils.getCellData(path, "LoginData", i, j);
			}
		}
		return loginData;
		
	}
	
	

}
