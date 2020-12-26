package com.TruckLogics.Pages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TruckLogics.Utilities.TestUtility;
import com.TruckLogics.Utilities.Xls_Reader;
import com.TruckLogics.driverpec.TestBase;
import com.pageload.Pageload;

public class ID_login extends TestBase{
	
TestUtility utl = new TestUtility();
	
	String ClientStateValue = "10";
	String ClientSKUValue = "1 - 2 Trucks - Owner Operator";
		
	@FindBy(id = "UserEmailAddress")
	WebElement UserId;

	
	@FindBy(id = "Password")
	WebElement Password;

	@FindBy(id = "SubmitLogin")
	WebElement SignButton;
	
	@FindBy(xpath="//body/main[1]/div[4]/section[1]/div[1]/div[2]/div[2]/div[2]/a[1]")
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
	
	@FindBy(xpath = "//tbody/tr[1]/td[7]/a[1]/i[1]")
	WebElement AddAccountIcon;
	
	@FindBy(xpath = "//a[@class='nextBtn'][contains(.,'Create Account')]")
	WebElement AddAccount;
	
	@FindBy(id = "skuList")
	WebElement Plan;
	
	@FindBy(xpath = "//label[@for='premium'][contains(.,'Premium')]")
	WebElement Premium;
	
	@FindBy(id = "saveuser")
	WebElement CreateAccount;
	
	@FindBy(xpath = "//tbody/tr[1]/td[7]/a[1]/i[1]")
	WebElement Manage;
	
	
	
	public ID_login() {
		
		PageFactory.initElements(driver, this);
	}

	
	public void login(String emailaddress, String pwd) {
		 	
		UserId.sendKeys(emailaddress);
		Password.sendKeys(pwd);
		SignButton.click();

	}

		
	public void NewClient()
	{
		
		driver.manage().timeouts()
		.pageLoadTimeout(Pageload.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		AddNewClient.click();
		driver.manage().timeouts()
		.pageLoadTimeout(Pageload.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		BusinessName.sendKeys("Wills Transits");
		
		ContactName.sendKeys("Will");
		
		Email.sendKeys("thiviprakash.g+id21@expressexcise.com");
		
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


	public void LoginCheck() throws InterruptedException {
		
		
		
		UserId.sendKeys("");
		Password.sendKeys("123123");
		SignButton.click();
		Thread.sleep(2000);
		
		UserId.clear();
		Password.clear();
		
		UserId.sendKeys("thiviprakash.g+dispatcher@expressexcise.com");
		Password.sendKeys("");
		SignButton.click();
		Thread.sleep(2000);
		
		UserId.clear();
		Password.clear();
		
		UserId.sendKeys("thiviprakaash.g+12@expressexcise.com");
		Password.sendKeys("123123");
		SignButton.click();
		Thread.sleep(2000);
		
		UserId.clear();
		Password.clear();
		
	
	}


	public void CreateClient() {
		driver.manage().timeouts()
		.pageLoadTimeout(Pageload.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		AddNewClient.click();
		driver.manage().timeouts()
		.pageLoadTimeout(Pageload.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		BusinessName.sendKeys("Frankling Trucking");
		
		
		ContactName.sendKeys("Frank");
		
		Email.sendKeys("thiviprakash.g+id28@expressexcise.com");
		
		Phone.sendKeys("7548562354");
		
		ManualAddress.click();
		
		Address1.sendKeys("71 NW 73rd St");
		
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



	public void CreateAccount() throws InterruptedException {
		
		Thread.sleep(10000);
		
		AddAccountIcon.click();
		
		driver.manage().timeouts()
		  .pageLoadTimeout(Pageload.LONG_WAIT, TimeUnit.SECONDS);
		
		AddAccount.click();
		
		driver.manage().timeouts()
		  .pageLoadTimeout(Pageload.LONG_WAIT, TimeUnit.SECONDS);
		
				
		Plan.click();
		
		driver.manage().timeouts()
		  .pageLoadTimeout(Pageload.LONG_WAIT, TimeUnit.SECONDS);
		
		Thread.sleep(5000);
		
		//utl.selectValueFromDropDownByValue(Plan, ClientSKUValue);
		
		utl.SelectValueByVisibleText(Plan, ClientSKUValue);
	
		driver.manage().timeouts()
		  .pageLoadTimeout(Pageload.LONG_WAIT, TimeUnit.SECONDS);
		
				
		CreateAccount.click();
		
		
	}
	
	public void Manage() throws InterruptedException {
		
		Thread.sleep(10000);
		
		Manage.click();
	}
	
	
		
}
