package com.TruckLogics.TestCases;

import java.io.IOException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.TruckLogics.Pages.ControlPanel;
import com.TruckLogics.driverpec.TestBase;


public class Controlpanel_ID extends TestBase{
	
	ControlPanel controlpanel;
	
	public Controlpanel_ID()
	{
		super();
	}

	@BeforeClass
	public void obj()
	{
		controlpanel = new ControlPanel();
	}
	
	@Test(priority=0)
	public void createclient() throws InterruptedException, IOException
	{
		controlpanel.NewClient();
	}
	
	
}
