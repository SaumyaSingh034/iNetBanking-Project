package com.iNetBanking.testCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.iNetBanking.utilities.BasicUtilityFiles;

public class BaseClassTest {
	
	public static WebDriver driver;
	Properties prop;
	String browserName = null;
	String urlInvoke;
	
	
	public BaseClassTest()
	{
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(BasicUtilityFiles.PROP_FILE_PATH);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void browserInvoke( )
	{
		
		urlInvoke = prop.getProperty("url");
		browserName = prop.getProperty("browser");
		System.out.println("********************URL--------> "+urlInvoke);
		System.out.println("********************Browser Name--------> "+browserName);
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			
		} else if (browserName.equalsIgnoreCase("ie")) {

			driver = new InternetExplorerDriver();
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+ "\\drivers\\IEServer.exe");

		} else if (browserName.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");

		} else if (browserName.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();
			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+ "\\drivers\\edgedriver.exe");

		} else {
			System.out.println("Please Check Your Browser. You have enter wrong browser......");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(BasicUtilityFiles.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(BasicUtilityFiles.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(urlInvoke);
	}
	
	
	
	

}
