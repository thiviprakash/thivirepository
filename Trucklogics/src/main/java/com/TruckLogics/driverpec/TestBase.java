package com.TruckLogics.driverpec;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.pageload.Pageload;
import io.github.bonigarcia.wdm.WebDriverManager;

import com.TruckLogics.Utilities.TestUtility;
import com.TruckLogics.Utilities.WebEventListner;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class TestBase {
	public static WebDriver driver; 
	public static Properties property;
	public static ChromeOptions chromeOptions;
	public static EventFiringWebDriver e_driver;
	public static ExtentTest test;
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
	public static WebEventListner eventListener; 
	
	
	public TestBase()
	{
		try 
		{
			property = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/url_credentials/credential.properties");
			property.load(ip);
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
		
	@BeforeSuite
	public void setExtent()
	{
		htmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/TruckLogics"+TestUtility.getSystemDate()+".html"));
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		
		htmlReporter.config().setReportName("TruckLogics Test Result");
		htmlReporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
	}

	public static Logger logger;
	
	public static void initialization(String Browser)
	{
		logger = Logger.getLogger("trucklogics");
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		
		if(Browser.equals("chrome"))
		{ 
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(Browser.equals("IE"))
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		else if(Browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(Browser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("Path of Driver Executable is not Set for any Browser");
		}
		
		//e_driver = new EventFiringWebDriver(driver);
		
		//eventListener = new WebEventListner();
		//e_driver.register(eventListener);
		//driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Pageload.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Pageload.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(property.getProperty("Url"));
	}

	@AfterMethod
	public void teardown(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE)
		{
			//TestUtility.getScreenshot(driver);
			//test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(TestUtility.getScreenshot(driver)).build());
			
			test=extent.createTest(result.getName()); // create new entry in the report
			test.log(Status.FAIL,MarkupHelper.createLabel(result.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted
			test.fail("Screenshot:", MediaEntityBuilder.createScreenCaptureFromPath(TestUtility.getScreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test=extent.createTest(result.getName()); // create new entry in the report
			test.log(Status.PASS,MarkupHelper.createLabel(result.getName(),ExtentColor.GREEN));
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test=extent.createTest(result.getName()); // create new entry in the report
			test.log(Status.SKIP,MarkupHelper.createLabel(result.getName(),ExtentColor.ORANGE));
		}
		//driver.quit();
	}
	
	@AfterTest
	public void endReport() 
	{
		  extent.flush();
		 }

	
}
