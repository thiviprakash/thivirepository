package com.TruckLogics.TestCases;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterClass;  
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.TruckLogics.driverpec.TestBase;
import com.pageload.Pageload;
import com.TruckLogics.Pages.Login;

public class LoginPage extends TestBase{
	Login login;
	public LoginPage()
	{
		super();
	}
	
	@Parameters("Browser")
	@BeforeTest(alwaysRun=false)
	public void setup(String Browser)
	{
		initialization(Browser);
		//System.out.println("TruckLogics Launched successfully");
		login = new Login();
		test = extent.createTest("Truck logics");
	}
	
	@Test(priority = 0)
	public void imtesting() {
		//extentTest = extent.createTest(method.getName());
		//test.info("Starting Application");
		driver.manage().timeouts().pageLoadTimeout(Pageload.LONG_WAIT, TimeUnit.SECONDS);
		login.imtesting();
		//test.info("Imtesting Testcase passed");
	}
  @Test(priority= 1)
  public void loginTest() {
	  login.login(property.getProperty("Email"),property.getProperty("password"));
	 // test.info("Login test cased passed");
  }
  
 
}
