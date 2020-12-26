package com.TruckLogics.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.TruckLogics.Utilities.TestUtility;
import com.TruckLogics.driverpec.TestBase;
import com.pageload.Pageload;

public class ControlPanel extends TestBase{

TestUtility utl = new TestUtility();
	
	String ClientStateValue = "10";
	
	WebDriverWait wait = new WebDriverWait(driver, 60);
	
	@FindBy(id="addNewuser")
	WebElement AddNewClient;
	
	@FindBy(id="BusinessName")
	WebElement BusinessName;
	
	@FindBy(id="ClientName")
	WebElement DBA;
	
	@FindBy(id="FirstName")
	WebElement ContactName;
	
	@FindBy(id="EmailAddress")
	WebElement Email;
	
	@FindBy(id="txtPhoneNo")
	WebElement Phone;
	
	@FindBy(id="txtPhoneNumberExtension")
	WebElement PhoneExt;
	
	@FindBy(xpath = "//*[@id=\"trEnterAddress\"]/td[2]/label")
	WebElement ManualAddress;
	
	@FindBy(id = "street_number")
	WebElement Address1;
	
	@FindBy(id = "route")
	WebElement Address2;
	
	@FindBy(id = "locality")
	WebElement City;
	
	@FindBy(id = "administrative_area_level_1")
	WebElement State;
	
	@FindBy(id = "postal_code")
	WebElement Zip;
	
	@FindBy(id = "btnSaveCustomer")
	WebElement AddClient;
	
	
	public void NewClient()
	{
		AddNewClient.click();
		driver.manage().timeouts()
		.pageLoadTimeout(Pageload.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		BusinessName.sendKeys("Barclays Trans");
		
		ContactName.sendKeys("Tom");
		
		Email.sendKeys("thiviprakash.g+id19@expressexcise.com");
		
		ManualAddress.click();
		
		Address1.sendKeys("571 NW 73rd St");
		
		City.sendKeys("Miami"); //Set city
		
		State.click();
		driver.manage().timeouts()
		  .pageLoadTimeout(Pageload.LONG_WAIT, TimeUnit.SECONDS);
		utl.selectValueFromDropDownByValue(State, ClientStateValue);
		driver.manage().timeouts()
		.pageLoadTimeout(Pageload.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		Zip.sendKeys("33150");
		
		AddClient.click();
	}
	

}

