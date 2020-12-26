package com.trucLogics.LeasedOP.Pages;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.TruckLogics.Utilities.TestUtility;
import com.TruckLogics.driverpec.TestBase;
import com.pageload.Pageload;


public class LeasedOperatorSettlement extends TestBase{
	
	TestUtility utl = new TestUtility();
	String _CarrierName = "Panther";

	@FindBy(id = "CarrierList")
	WebElement CarrierNameList;
	
	@FindBy(xpath = "/html/body/div[7]/div[3]/div/div/form/table/tbody/tr[1]/td[2]/a")
	WebElement AddNewCarrierButton;
//Add new carrier
	@FindBy(id = "txtCompanyName")
	WebElement AddNewCarrierName;
	
	@FindBy(id = "MainEmailAddress")
	WebElement CarrierEmail;
	
	@FindBy(xpath = "/html/body/div[11]/div/div/form/div[1]/div/div[3]/table/tbody/tr[10]/td[2]/input[1]")
	WebElement ManualAddress;
	
	@FindBy(id = "street_number_popup_carrier")
	WebElement CarrierAddress1;
	
	@FindBy(id = "route_popup_carrier")
	WebElement CarrierAddress2;
	
	@FindBy(id = "locality_popup_carrier")
	WebElement CarrierCity;
	
	@FindBy(id = "administrative_area_level_1_carrier_popup")
	WebElement CarrierState;
	
	@FindBy(id = "postal_code_popup_carrier")
	WebElement CarrierZipcode;
	
	@FindBy(xpath = "/html/body/div[11]/div/div/form/div[2]/div/a")
	WebElement AddcarrierCancel;
	
	@FindBy(xpath = "/html/body/div[11]/div/div/form/div[2]/div/input")
	WebElement AddcarrierSave;
//Period start date, End date, and Check date
	@FindBy(id = "PeriodStartDate")
	WebElement PeriodStartDate;
	
	@FindBy(id = "PeriodEndDate")
	WebElement PeriodEndDate;
	
	@FindBy(id = "checkDate")
	WebElement CheckDate;
	
	LeasedOperatorSettlement()
	{
		PageFactory.initElements(driver, this); // initialize driver
	}
	
	public void SelectCarrier()
	{
		/*Read carrier name from the test data sheet and choose the required carrier name from the drop down. 
		 * Carrier names are stored in list once read the name from sheet it will check whether the carrier is available on list or not
		 * If the carrier is available on list, it will be selected otherwise it will be added as new carrier
		 * like carrier name will read the period start and end date and check date from the 
		 */
		
		 
	}
	

}
