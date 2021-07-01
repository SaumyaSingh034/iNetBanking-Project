package com.iNetBanking.testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.iNetBanking.utilities.BasicUtilityFiles;

public class BaseClassTest {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public static Logger logger;
	//String urlInvoke = "https://demo.guru99.com/v4/index.php";
	
	@Parameters("browser")
	@BeforeClass
	public void browserInvoke(String browserName )
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
		
		//browserName = prop.getProperty("browser");
		 logger = Logger.getLogger("INetBanking");
		PropertyConfigurator.configure("log4j.properties");
		
		System.out.println("********************Browser Name--------> "+browserName);
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromepath"));
			ChromeOptions capability = new ChromeOptions();
			capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
			driver = new ChromeDriver(capability);
			
		} else if (browserName.equalsIgnoreCase("ie")) {

			driver = new InternetExplorerDriver();
			System.setProperty("webdriver.ie.driver", prop.getProperty("iepath"));

		} else if (browserName.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();
			System.setProperty("webdriver.gecko.driver",prop.getProperty("firefoxpath"));

		} else if (browserName.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();
			System.setProperty("webdriver.edge.driver",prop.getProperty("edgePath"));

		} else {
			System.out.println("Please Check Your Browser. You have enter wrong browser......");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(BasicUtilityFiles.IMPLICIT_WAIT, TimeUnit.SECONDS);
		//System.out.println("*********URL************* invoked********* "+prop.getProperty("urlInvoke"));

		
		driver.get(prop.getProperty("url"));
		logger.info(" URL is launced***** --> "+prop.getProperty("url"));
		
	}
	
	public Boolean isAlertExits()
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver, String tname)
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" +tname+ ".png");
		try {
			FileUtils.copyFile(source, target);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Screenshot Taken");
		
	}
	
	
	
	

}
