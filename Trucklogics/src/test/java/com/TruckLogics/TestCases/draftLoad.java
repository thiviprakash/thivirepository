package com.TruckLogics.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.TruckLogics.Pages.Load;
import com.TruckLogics.driverpec.TestBase;
import com.pageload.Pageload;


public class draftLoad extends TestBase{
	Load load;
		public draftLoad()
		{
			super();
		}
		
		@BeforeClass
		public void obj()
		{
				load = new Load();
		}
		
		@Test(priority=3)
		public void createdraftwithoutconsignee() throws InterruptedException, IOException
		{
		  Thread.sleep(10000);
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
		  load.draftLoad();
		  driver.manage().timeouts()
		  .pageLoadTimeout(Pageload.LONG_WAIT, TimeUnit.SECONDS);
		}
		
		
		@Test(priority=4)
		public void createdraftwithconsignee() throws InterruptedException, IOException
		{
		  Thread.sleep(10000);
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
		  load.draftLoad();
		  driver.manage().timeouts()
		  .pageLoadTimeout(Pageload.LONG_WAIT, TimeUnit.SECONDS);
		}
		
		
		@Test(priority=5)
		public void createdraftwithfees() throws InterruptedException, IOException
		{
		  Thread.sleep(10000);
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
		  load.draftLoadwithFee();
		 }
			
				
}
