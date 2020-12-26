package com.TruckLogics.TestCases;

import com.TruckLogics.driverpec.TestBase;
import com.pageload.Pageload;
import org.testng.annotations.AfterClass;  
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TruckLogics.Pages.IFTA;

public class IftaTest extends TestBase{
 IFTA ifta;
 public IftaTest()
 {
	 super();
 }
 
 @BeforeMethod
 public void obj()
 {
	 ifta = new IFTA();
 }
 @Test
public void Startreturn()throws InterruptedException, IOException
{
	ifta.ifta();
	driver.manage().timeouts().pageLoadTimeout(Pageload.IMPLICIT_WAIT, TimeUnit.SECONDS);
	ifta.startreturn();
}
 @AfterClass
 public void AfterClass()
 {
	 System.out.println("IFTA class has been executed successfully");
 }
}
