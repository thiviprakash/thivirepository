package com.TruckLogics.Pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.TruckLogics.driverpec.TestBase;

public class IFTA extends TestBase{
	
	@FindBy(xpath = "//*[@id=\"liIFTA\"]")
	WebElement IFTA;
	
	@FindBy(xpath = "//*[@id=\"diviftadetail\"]/table[5]/tbody/tr/td[1]/div/table/tbody/tr/td[2]/a")
	WebElement StartReturn;
	
	@FindBy(id = "tblTruckList")
	WebElement TruckList;
	
	public IFTA()
	{
		PageFactory.initElements(driver, this);
	}
	public void ifta()
	{
		IFTA.click();
	}
	public void startreturn()
	{
		StartReturn.click();
	}

}
