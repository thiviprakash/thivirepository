package com.TruckLogics.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.TruckLogics.Pages.Load;
import com.TruckLogics.driverpec.TestBase;
import com.pageload.Pageload;

public class loadPageTest extends TestBase{
	Load load; 
	  public loadPageTest()
	  {
		  super();
	  }
	  
	  @BeforeClass
	  public void obj()
	  {
		  load = new Load();
	  }
	  @Test(priority=3)
	  public void withoutHaulingFee() throws InterruptedException, IOException
	  {
		  driver.manage().timeouts()
			.pageLoadTimeout(Pageload.IMPLICIT_WAIT, TimeUnit.SECONDS);
		  load.NewLoad();
		  driver.manage().timeouts()
		  .pageLoadTimeout(Pageload.LONG_WAIT, TimeUnit.SECONDS);
		  load.Loadtype(1);
		  driver.manage().timeouts()
		  .pageLoadTimeout(Pageload.LONG_WAIT, TimeUnit.SECONDS);
		  load.AddNewCustomer();
		  driver.manage().timeouts()
		  .pageLoadTimeout(Pageload.LONG_WAIT, TimeUnit.SECONDS);
		  load.ShipperDatepicker();
		 driver.manage().timeouts()
		  .pageLoadTimeout(Pageload.LONG_WAIT, TimeUnit.SECONDS);
		  load.SelectCustomer();
		  driver.manage().timeouts()
		  .pageLoadTimeout(Pageload.LONG_WAIT, TimeUnit.SECONDS);
		  load.WithoutHaulingFee();
		  driver.manage().timeouts()
		  .pageLoadTimeout(Pageload.LONG_WAIT, TimeUnit.SECONDS);
	  }
	  @Test(priority=4)
	  public void withHaulingFee()throws InterruptedException, IOException
	  {
		  driver.manage().timeouts()
			.pageLoadTimeout(Pageload.IMPLICIT_WAIT, TimeUnit.SECONDS);
		  load.NewLoad();
		  driver.manage().timeouts()
		  .pageLoadTimeout(Pageload.LONG_WAIT, TimeUnit.SECONDS);
		  load.Loadtype(1);
		  driver.manage().timeouts()
		  .pageLoadTimeout(Pageload.LONG_WAIT, TimeUnit.SECONDS);
		  load.AddNewCustomer();
		  driver.manage().timeouts()
		  .pageLoadTimeout(Pageload.LONG_WAIT, TimeUnit.SECONDS);
		  load.ShipperDatepicker();
		 driver.manage().timeouts()
		  .pageLoadTimeout(Pageload.LONG_WAIT, TimeUnit.SECONDS);
		  load.SelectCustomer();
		  driver.manage().timeouts()
		  .pageLoadTimeout(Pageload.LONG_WAIT, TimeUnit.SECONDS);
		  load.LoadCharge();
	  }
	  
	  
}
