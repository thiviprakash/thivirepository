package com.TruckLogics.TestCases;

import java.lang.reflect.Method;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;  
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.TruckLogics.driverpec.TestBase;
import com.pageload.Pageload;
import com.TruckLogics.Pages.ID_login;
import com.TruckLogics.Pages.Login;
import com.TruckLogics.Utilities.Xls_Reader;

public class ID_SignIn_TestCase extends TestBase{
	
	ID_login login;
	
    public ID_SignIn_TestCase() {
		
		super();
	}
    
    @Parameters("Browser")
	@BeforeTest(alwaysRun=false)
	public void setup(String Browser)
	{
		initialization(Browser);
		System.out.println("TruckLogics Launched successfully");
		login = new ID_login();
		test = extent.createTest("Truck logics");
	}
    
    @Test(priority= 0)
	  public void invalidlogin() throws Exception {
				 
		 
			login.LoginCheck();
	     
			driver.manage().timeouts().pageLoadTimeout(Pageload.LONG_WAIT, TimeUnit.SECONDS);
			login.login(property.getProperty("Email"),property.getProperty("password"));
	 
						
			driver.close();
			
			
	 }

}
