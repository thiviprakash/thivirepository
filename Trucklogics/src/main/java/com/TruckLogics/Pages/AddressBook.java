package com.TruckLogics.Pages;

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


public class AddressBook extends TestBase{
TestUtility utl = new TestUtility();

@FindBy(id="liAddressBook")
WebElement AddressBookMenu;

public void abmenu()
{
	AddressBookMenu.click();
}
public void GetAllContacts()
{

	
    utl.getAllContacts(driver);
}

}
