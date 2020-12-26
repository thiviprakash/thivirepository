package com.TruckLogics.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TruckLogics.Pages.Load;
import com.TruckLogics.driverpec.TestBase;
import com.pageload.Pageload;


public class LoadTest extends TestBase{
  Load load; 
  public LoadTest()
  {
	  super();
  }
  
  @BeforeClass
  public void obj()
  {
	  load = new Load();
  }
  
  @Test(priority=3)
  public void CreateLoadCustomerWithoutHauling()throws InterruptedException, IOException
  {
	  // Create customer load with out a hauling fee. (Single shipper and single consignee)
	  // Enter Shipper and consignee then click the create load button and capture the Zero hauling fee validation
	  System.out.println("test case started-p3");
	  load.NewLoad();
	  System.out.println("p3");
	  driver.manage().timeouts()
	  .pageLoadTimeout(Pageload.LONG_WAIT, TimeUnit.SECONDS);
	  load.Loadtype(1);
	  driver.manage().timeouts()
	  .pageLoadTimeout(Pageload.IMPLICIT_WAIT, TimeUnit.SECONDS);
	  
	  load.AddNewCustomer();
	  System.out.println("Customer p3 Added successfully");
	  driver.manage().timeouts()
	  .pageLoadTimeout(Pageload.IMPLICIT_WAIT, TimeUnit.SECONDS);
	  load.ShipperDatepicker();
	  System.out.println("shipper added-p3");
	  driver.manage().timeouts()
	  .pageLoadTimeout(Pageload.IMPLICIT_WAIT, TimeUnit.SECONDS);
	  load.AddNewConsignee();
	  System.out.println("consignee added-p3");
	  System.out.println("Consignee Added successfully");
	  driver.manage().timeouts()
	  .pageLoadTimeout(Pageload.IMPLICIT_WAIT, TimeUnit.SECONDS);
	  System.out.println("consignee 2-added-p3");
	  load.WithoutHaulingFee();
	  System.out.println("without-p3");
	 // test.info("Load without hauling fee test case passed");
  }
  
  @Test(priority=4)
  public void CreateLoadCustomerWithHauling() throws InterruptedException
  {
	  load.NewLoad();
	  driver.manage().timeouts()
	  .pageLoadTimeout(Pageload.LONG_WAIT, TimeUnit.SECONDS);
	  load.Loadtype(1);
	  driver.manage().timeouts()
	  .pageLoadTimeout(Pageload.IMPLICIT_WAIT, TimeUnit.SECONDS);
	  load.AddNewCustomer();
	  System.out.println("Customer Added successfully");
	  driver.manage().timeouts()
	  .pageLoadTimeout(Pageload.IMPLICIT_WAIT, TimeUnit.SECONDS);
	  load.ShipperDatepicker();
	  driver.manage().timeouts()
	  .pageLoadTimeout(Pageload.IMPLICIT_WAIT, TimeUnit.SECONDS);
	  Thread.sleep(5000);
	  load.AddNewConsignee();
	  System.out.println("Consignee Added successfully");
	  driver.manage().timeouts()
	  .pageLoadTimeout(Pageload.IMPLICIT_WAIT, TimeUnit.SECONDS);
	  load.LoadCharge();
	  //test.info("Load with hauling fee test passed");
  }
}
