package com.TruckLogics.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TruckLogics.driverpec.TestBase;

public class Login extends TestBase{


@FindBy(id = "cdnPassword")
WebElement imtesting;

@FindBy(id = "btnCdnSubmit")
WebElement imtestingbtn;

@FindBy(id = "EmailAddress")
WebElement UserId;

@FindBy(id = "Password")
WebElement Password;

@FindBy(id = "btnSubmit")
WebElement SignButton;

public Login() {
	PageFactory.initElements(driver, this);
}

public void imtesting() {
	imtesting.sendKeys("imtesting");
	imtestingbtn.click();
}

public void login(String emailaddress, String pwd) {
	UserId.sendKeys(emailaddress);
	Password.sendKeys(pwd);
	SignButton.click();

}



}
