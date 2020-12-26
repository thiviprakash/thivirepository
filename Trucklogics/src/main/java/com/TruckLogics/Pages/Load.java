package com.TruckLogics.Pages;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.TruckLogics.Utilities.TestUtility;
import com.TruckLogics.Utilities.Wait;
import com.TruckLogics.driverpec.TestBase;
import com.pageload.Pageload;

public class Load extends TestBase{
	TestUtility utl = new TestUtility();
	String ShipperStateValue = "10";
	String ShippingTimeStamp = "08/13/2020"; 
	String ConsigneeStateValue = "19";
	WebDriverWait wait = new WebDriverWait(driver, 60);
	
	@FindBy(id="liOrders")
	WebElement LoadMenu;
	
	@FindBy(linkText ="New Load")
	WebElement AddNewLoad;
	
	@FindBy(xpath = "//*[@id=\"ftlBtn\"]/div[5]/input")
	WebElement FTL;
	
	@FindBy(xpath = "//*[@id=\"ltlBtn\"]/div[5]/input")
	WebElement LTL;
//Load options
	@FindBy(id = "Customer")
	WebElement Customer;
	
	@FindBy(id = "Carrier")
	WebElement Carrier;
	
	@FindBy(id = "Broker")
	WebElement Broker;
	
	@FindBy(id = "YardMoveOrInventoryTransfer")
	WebElement YardInventory;
	
	@FindBy(id = "btnSaveLoadSettings")
	WebElement LoadSettings;
	
//Add Button
	@FindBy(id = "aAddCustomer")
	WebElement AddCustomer;
	
	@FindBy(id = "aAddCarrier")
	WebElement AddCarrier;
	
	@FindBy(id = "aAddBroker")
	WebElement AddBroker;
	
	@FindBy(id = "txtCustomerName")
	WebElement CustomerName;
	
	@FindBy(xpath = "/html/body/ul[1]")
	WebElement CustomernameList;
	
	@FindBy(xpath = "/html/body/main/section/div[4]/div/div/form[1]/div[7]/div[1]/div[3]/table/tbody/tr[1]/td[4]/input")
	WebElement CustomerNameCombobox;
	
//Quick Add Customer	
	@FindBy(xpath = "//*[@id=\"txtCompanyName\"]")
	WebElement CompanyName;
	
	@FindBy(id = "txtEmail")
	WebElement CustomerEmail;
	
	@FindBy(id = "autocompletepopup")
	WebElement GoogleAddress;
	
	@FindBy(xpath = "/html/body/div[4]/div/div/form/div[2]/div/div[3]/table/tbody/tr[11]/td[2]/label/b")
	WebElement ManualAddress;
	
	@FindBy(id = "street_number_popup")
	WebElement Address1;
	
	@FindBy(id = "route_popup")
	WebElement Address2;
	
	@FindBy(id = "locality_popup")
	WebElement City;
	
	@FindBy(id = "administrative_area_level_1_popup")
	WebElement State;
	
	@FindBy(id = "postal_code_popup")
	WebElement Zipcode;
	
	@FindBy(id = "btnCancel")
	WebElement Cancel;
	
	@FindBy(id = "btnSaveCustomer")
	WebElement SaveCustomer;
//Shipper	
	@FindBy(id = "txtPickupDate")
	WebElement ShippingTime;
//Quick Add consignee
	@FindBy(id = "ConsigneeName")
	WebElement ConsigneeList;
	
	@FindBy(id = "AddConsigneeName")
	WebElement AddConsignee;
	
	@FindBy(xpath = "//*[@id=\"txtCompanyName\"]")
	WebElement ConsigneeName;
	
	@FindBy(id = "autocomplete")
	WebElement ConsigneeGoogleAddress;
	
	@FindBy(xpath = "/html/body/div[4]/div/div/form/div[2]/div/div[3]/table/tbody/tr[9]/td[2]/label/b")
	WebElement ConsigneeManualAddress;
	
	@FindBy(id = "street_number_ShipConsig")
	WebElement ConsigneeAdress1;
	
	@FindBy(id = "route_ShipConsig")
	WebElement ConsigneeAdress2;
	
	@FindBy(id = "locality_ShipConsig")
	WebElement ConsigneeCity;
	
	@FindBy(id = "administrative_area_level_1_ShipConsig")
	WebElement ConsigneeState;
	
	@FindBy(id = "postal_code_ShipConsig")
	WebElement ConsigneeZipcode;
	
	@FindBy(id = "btnSaveShipperConSignee")
	WebElement SaveConsignee; // add consignee pop-up
//Charges	
	@FindBy(id = "FeeMethod")
	WebElement HaulingFeemethod;
	
	@FindBy(id = "FeeRate")
	WebElement HaulingFeeRate;
	
	@FindBy(id = "FSCAmountType")
	WebElement SurchargeType;
	
	@FindBy(id = "FSCAmountRate")
	WebElement SurchargeRate;
	
	@FindBy(id = "AccessorialFeesList_0__UserAccessoryFeeTypeId")
	WebElement AccessorialFeeType;
	
	@FindBy(id = "AccessorialFeesList_0__AccessoryFeeRate")
	WebElement AccessorialFeerate;
	
	@FindBy(id = "AccessorialDeductionList_0__UserAccessoryDeductionTypeId")
	WebElement AccessorialDeductionType;
	
	@FindBy(id = "AccessorialDeductionList_0__AccessoryDeductionRate")
	WebElement AccessorialDeductionrate;
	
	@FindBy(xpath = "/html/body/main/section/div[4]/div/div/form[3]/div[1]/div[4]/div/table/tbody/tr[3]/td[5]")
	WebElement HaulingFeeCharge;
	
	@FindBy(xpath = "/html/body/main/section/div[4]/div/div/form[3]/div[1]/div[4]/div/table/tbody/tr[5]/td[5]")
	WebElement FuelSurChargeAmount;
	
	@FindBy(xpath = "/html/body/main/section/div[4]/div/div/form[3]/div[1]/div[4]/div/table/tbody/tr[18]/td[5]")
	WebElement TotalLoadCharge;
	
//Mile Calculation Methods
	@FindBy(id = "chkgoogleMap")
	WebElement Google;
	
	@FindBy(id = "chkPromiles")
	WebElement ProMiles;
	
	@FindBy(id = "chkManual")
	WebElement Manual;
	
	@FindBy(id = "Miles")
	WebElement ManualMileValue;
			
	@FindBy(xpath = "/html/body/main/section/div[4]/div/div/form[3]/div[6]/input[2]")
	WebElement CreateLoadButton;
	
	@FindBy(id = "btnSaveDraft")
	WebElement CreateDraftLoad;
	
	@FindBy(id = "combobox3")
	WebElement ConsigneeDropDown;
	
	@FindBy(id = "SaveShipperId")
	WebElement SaveShipper;
	
	@FindBy(id ="SaveConsigneeId")
	WebElement SaveConsigneeDetails; // Click save button in consignee
// Freight details
	@FindBy(id = "NameDescription1")
	WebElement Description1;
	
	@FindBy(id = "Weight1")
	WebElement Weight1;
	
	@FindBy( id = "ddWeightMeasurementUnit1")
	WebElement WeightUnit1;
	
	@FindBy(id = "Pieces1")
	WebElement Qty1;
	
	@FindBy(id = "ddPackingType1")
	WebElement QtyUnit;
	
	@FindBy(id = "Length1")
	WebElement Length1;
	
	@FindBy(id = "Width1")
	WebElement Width1;
	
	@FindBy(id = "Height1")
	WebElement Height1;
	
	@FindBy(id = "OrderFreightUI_FreightClass1")
	WebElement FreightClass1;
	
	@FindBy(id = "DeclaredValue1")
	WebElement DeclaredValue1;
//Additional Details
	@FindBy(id = "OrderFreightUI_TrailerGroup")
	WebElement TailerGroup;
	
	@FindBy(id = "drpTrailerType")
	WebElement TrailerType;
	//Loadtype
	@FindBy(id = "OrderFreightUI_IsHazardousMaterial")
	WebElement Hazmat;
	
	@FindBy(id = "OrderFreightUI_IsOversize")
	WebElement OverSizeLoad;
	
	@FindBy(id = "OrderFreightUI_IsRefer")
	WebElement Reefer;
	
	@FindBy(id = "OrderFreightUI_IsTanker")
	WebElement Tanker; 
	public Load()
	{
		PageFactory.initElements(driver, this); // initialize driver
	}
	
	public void NewLoad()
	{
		
		LoadMenu.click(); //clicks load in menu from dashboard
		//driver.manage().timeouts()
		//.pageLoadTimeout(Pageload.LONG_WAIT, TimeUnit.SECONDS);
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(AddNewLoad));
		Actions actions = new Actions(driver);
		actions.moveToElement(AddNewLoad).click().perform();
		//NewLoad.click(); // Click add new button in Load dashboard
		driver.manage().timeouts()
		.pageLoadTimeout(Pageload.IMPLICIT_WAIT, TimeUnit.SECONDS);
		// Following code will check the load preference pop-up is exists or not
		
		WebDriverWait wait = new WebDriverWait(driver, 300);
		utl.SwitchToPopup(driver);
		
		
	}
	
	public void Loadtype(int Type)
	{
		//1-FTL, 2-LTL
		
		if(Type==1)
		{
			FTL.click();
		}
		if(Type==2)
		{
			LTL.click();
		}
		
	}
	
	public void SelectLoadNumber()
	{
		WebDriverWait wait = new WebDriverWait(driver, 300 /*timeout in seconds*/);
		if(wait.until(ExpectedConditions.alertIsPresent())==null)
		    System.out.println("alert was not present");
		else
		    System.out.println("alert was present");
	}
	public void AddNewCustomer()
	{
		driver.manage().timeouts()
		.pageLoadTimeout(Pageload.IMPLICIT_WAIT, TimeUnit.SECONDS);
		//Add new customer 
		//Actions actions = new Actions(driver);
		//actions.moveToElement(AddCustomer).click().perform();
		AddCustomer.click(); // Clicks Add new customer button
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(CompanyName));
		CompanyName.sendKeys("Tesla Motors");
		ManualAddress.click(); 
		Address1.sendKeys("571 NW 73rd St"); // set Address1
		City.sendKeys("Miami"); //Set city
		State.click();
		driver.manage().timeouts()
		  .pageLoadTimeout(Pageload.LONG_WAIT, TimeUnit.SECONDS);
		utl.selectValueFromDropDownByValue(State, ShipperStateValue);
		driver.manage().timeouts()
		.pageLoadTimeout(Pageload.IMPLICIT_WAIT, TimeUnit.SECONDS);
		Zipcode.sendKeys("33150");
		SaveCustomer.click();
	}
	
	

	public void ShipperDatepicker()
	{
		utl.selectDateByJS(driver, ShippingTime, ShippingTimeStamp);
		driver.manage().timeouts()
		.pageLoadTimeout(Pageload.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
	}
	
	public void AddNewConsignee() throws InterruptedException  
	{
		
		driver.manage().timeouts()
		.pageLoadTimeout(Pageload.IMPLICIT_WAIT, TimeUnit.SECONDS);
		//SaveShipper.click();
		//utl.scrollIntoElementByJavaScript(AddConsignee, driver);
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(AddConsignee));
		Actions actions = new Actions(driver);
	    actions.moveToElement(AddConsignee).click().perform();
		//AddConsignee.click(); // Clicks Add consignee button
	    new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(ConsigneeName));
       ConsigneeName.sendKeys("Bellwood Steels"); // Set consignee name
		driver.manage().timeouts()
		.pageLoadTimeout(Pageload.IMPLICIT_WAIT, TimeUnit.SECONDS);
		ConsigneeManualAddress.click(); 
		driver.manage().timeouts()
		.pageLoadTimeout(Pageload.IMPLICIT_WAIT, TimeUnit.SECONDS);
		ConsigneeAdress1.sendKeys("1415 Tulane Ave"); // set Address1
		ConsigneeCity.sendKeys("New Orleans"); //Set city
		driver.manage().timeouts()
		.pageLoadTimeout(Pageload.IMPLICIT_WAIT, TimeUnit.SECONDS);
		ConsigneeState.click();
		driver.manage().timeouts()
		.pageLoadTimeout(Pageload.IMPLICIT_WAIT, TimeUnit.SECONDS);
		utl.selectValueFromDropDownByValue(ConsigneeState, ConsigneeStateValue);
		driver.manage().timeouts()
		.pageLoadTimeout(Pageload.IMPLICIT_WAIT, TimeUnit.SECONDS);
		ConsigneeZipcode.sendKeys("70112");
		SaveConsignee.click();
		driver.manage().timeouts()
		.pageLoadTimeout(Pageload.EXPLICIT_WAIT, TimeUnit.SECONDS);
		Thread.sleep(10000);
		SaveConsigneeDetails.click();
	}
	
	public void WithoutHaulingFee()
	{		
		driver.manage().timeouts()
		.pageLoadTimeout(Pageload.LONG_WAIT, TimeUnit.SECONDS);
		utl.scrollDownPageByJavaScript(driver);
		driver.manage().timeouts()
		.pageLoadTimeout(Pageload.LONG_WAIT, TimeUnit.SECONDS);
		CreateLoadButton.click();
		driver.manage().timeouts()
		.pageLoadTimeout(Pageload.LONG_WAIT, TimeUnit.SECONDS);
		String FeeZeroValidation = new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.id("lblerrortotalamt"))).getText();
		System.out.println("Load fee validation: "+FeeZeroValidation);
		Assert.assertEquals(FeeZeroValidation, "Load charges could not be zero");
	}
	
	public void SelectCustomer()
	{
		//CustomerNameCombobox.sendKeys("Google Loads, Worthington, MN");
		try {
			
			WebElement consignee = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ConsigneeBox")));
			consignee.sendKeys("Big Boy Concessions, El Paso, TX");
			Thread.sleep(3000);
			//List<WebElement> dropdownOptions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#ConsigneeName")));
			//System.out.println(dropdownOptions);
			//dropdownOptions.get(0).click();
			consignee.sendKeys(Keys.ARROW_DOWN);
			consignee.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			//driver.manage().timeouts()
			//.pageLoadTimeout(Pageload.IMPLICIT_WAIT, TimeUnit.SECONDS);
			//SaveConsigneeDetails.click();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		
	}
	
	public void LoadCharge()
	{
		HaulingFeeRate.sendKeys("1000");
		SurchargeRate.sendKeys("10");
		//utl.selectValueFromDropDownByValue(AccessorialFeeType, "12578");
		//AccessorialFeerate.sendKeys("100");
		//utl.selectValueFromDropDownByValue(AccessorialDeductionType, "12580");
		//AccessorialDeductionrate.sendKeys("50");
		ManualMileValue.sendKeys("234");
		driver.manage().timeouts()
		.pageLoadTimeout(Pageload.LONG_WAIT, TimeUnit.SECONDS);
		utl.scrollDownPageByJavaScript(driver);
		driver.manage().timeouts()
		.pageLoadTimeout(Pageload.LONG_WAIT, TimeUnit.SECONDS);
		String H1 = HaulingFeeCharge.getText();
		String H2 = H1.replace("$", "").replace(",", "");
		System.out.println("Hauling string:"+H2);
		int HaulingFeeRateValue = Integer.parseInt(new DecimalFormat("#").format(Double.parseDouble(H2)));
		String FS = FuelSurChargeAmount.getText();
		String FS2 = FS.replace("$", "").replace(",", "");
		int SurchargeRateValue = Integer.parseInt(new DecimalFormat("#").format(Double.parseDouble(FS2)));
		int TotalAmount =  HaulingFeeRateValue + SurchargeRateValue;
		String T1 = TotalLoadCharge.getText();
		String T2 = T1.replace("$", "").replace(",", "");
		int TotalLoadChargeValue = Integer.parseInt(new DecimalFormat("#").format(Double.parseDouble(T2)));
		Assert.assertEquals(TotalLoadChargeValue, TotalAmount);
		CreateLoadButton.click();
	}
	
	public void draftLoadwithFee()
	{
		HaulingFeeRate.sendKeys("1000");
		SurchargeRate.sendKeys("10");
		//utl.selectValueFromDropDownByValue(AccessorialFeeType, "12578");
		//AccessorialFeerate.sendKeys("100");
		//utl.selectValueFromDropDownByValue(AccessorialDeductionType, "12580");
		//AccessorialDeductionrate.sendKeys("50");
		ManualMileValue.sendKeys("234");
		driver.manage().timeouts()
		.pageLoadTimeout(Pageload.LONG_WAIT, TimeUnit.SECONDS);
		utl.scrollDownPageByJavaScript(driver);
		driver.manage().timeouts()
		.pageLoadTimeout(Pageload.LONG_WAIT, TimeUnit.SECONDS);
		String H1 = HaulingFeeCharge.getText();
		String H2 = H1.replace("$", "").replace(",", "");
		System.out.println("Hauling string:"+H2);
		int HaulingFeeRateValue = Integer.parseInt(new DecimalFormat("#").format(Double.parseDouble(H2)));
		String FS = FuelSurChargeAmount.getText();
		String FS2 = FS.replace("$", "").replace(",", "");
		int SurchargeRateValue = Integer.parseInt(new DecimalFormat("#").format(Double.parseDouble(FS2)));
		int TotalAmount =  HaulingFeeRateValue + SurchargeRateValue;
		String T1 = TotalLoadCharge.getText();
		String T2 = T1.replace("$", "").replace(",", "");
		int TotalLoadChargeValue = Integer.parseInt(new DecimalFormat("#").format(Double.parseDouble(T2)));
		Assert.assertEquals(TotalLoadChargeValue, TotalAmount);
		CreateDraftLoad.click();
	}
	
	public void draftLoad()
	{
		CreateDraftLoad.click();
	}
	
}
