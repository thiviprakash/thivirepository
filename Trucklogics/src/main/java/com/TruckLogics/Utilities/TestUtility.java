package com.TruckLogics.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.TruckLogics.driverpec.TestBase;

public class TestUtility extends TestBase{
	public static Workbook book;
	public static Sheet sheet;
	
	public static JavascriptExecutor javaScript;
	public static Actions actions;
	public static Select select;
	public static Alert alert;
//#1	
		//Explicit Wait to Send Data to any WebElement.
		public static void sendKeys(WebDriver driver, WebElement element, int timeout, String value) 
		{
			new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(value);
		}

//#2
		//Explicit Wait for Element To Be Visible.
		public static void waitForElementToBeVisible(WebDriver driver, By locator, int timeout)
		{
			new WebDriverWait(driver, timeout).
			until(ExpectedConditions.visibilityOfElementLocated(locator));
		}
//#3
		//Mouse Hover using Action class
		//public void mousehover(WebDriver driver, WebElement element)
		//{
		//	Actions actions = new Actions(driver);
		//	actions.moveToElement(element).build().perform();
	//	}
	//	
//#4	
		// Click hidden element using js executer
		public void click(WebElement element, WebDriver driver)
		{
			javaScript = ((JavascriptExecutor) driver);
			javaScript.executeScript("arguments[0].click();", element);
		}
		
//5.
		//Explicit Wait to Click on any WebElement.
		public void clickOn(WebDriver driver, WebElement element, int timeout) 
		{
			new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		}
//6
		//To Select a value from Drop Down by using SelectByValue Method.
		public static void selectValueFromDropDownByValue(WebElement element, String value) 
		{
			select = new Select(element);
			select.selectByValue(value);
		}
//7
		//To Select Calendar Date Or Data Picker Using Java Script Executor.
		public static void selectDateByJS(WebDriver driver, WebElement element, String dateValue) 
		{
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].setAttribute('value','" + dateValue + "');", element);
		}
//8
		//To Scroll into WebElement View by using JavaScript Executor.
		public static void scrollIntoElementByJavaScript(WebElement element, WebDriver driver) 
		{
			javaScript = ((JavascriptExecutor) driver);
			javaScript.executeScript("arguments[0].scrollIntoView(true);", element);
		}
//9
		public static void scrollDownPageByJavaScript(WebDriver driver) 
		{
			javaScript = ((JavascriptExecutor) driver);
			javaScript.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		}
//10
		// Select a required value from drop-down
		public static void selectDropDownValue(String idValue, String value) 
		{
			List<WebElement> monthList = driver.findElements(By.id(idValue));
			for(int i=0; i<monthList.size(); i++) 
			{
				if(monthList.get(i).getText().equals(value)) 
				{
					monthList.get(i).click();
					break;
				}
			}
		}
//11
		// Switch to pop-up
		public void SwitchToPopup(WebDriver driver)
		{
			String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
			String subWindowHandler = null;

			Set<String> handles = driver.getWindowHandles(); // get all window handles
			Iterator<String> iterator = handles.iterator();
			while (iterator.hasNext()){
			    subWindowHandler = iterator.next();
			}
			driver.switchTo().window(subWindowHandler); // switch to popup window

			// Now you are in the popup window, perform necessary actions here

			driver.switchTo().window(parentWindowHandler);
		}
//12 
		// Select value by visible Text
		public void SelectValueByVisibleText(WebElement element, String value)
		{
			Select select = new Select(element); 
			select.selectByVisibleText(value);
		}
//13
		//Get amount number as string and convert that to Integer
		public void GetAmount(WebElement element)
		{
			String AmountWithChar = element.getText();
			String AmountWithoutChar = AmountWithChar.replace("$", "").replace(",", "");
			int Amount = Integer.parseInt(new DecimalFormat("#").format(Double.parseDouble(AmountWithoutChar)));
		}
//14
		//select all items from the drop-down and stored them in a list
		public void SelectItemsAddInList(WebElement element)
		{
			Select select = new Select(element);
			List<WebElement> ItemsList = select.getOptions();
		}
//15
		//Set date and time for log
		public static void setDateForLog4j()
		{
			SimpleDateFormat dateFormat = new SimpleDateFormat("_dd_MM_yyy_hh:mm:ss");
			System.setProperty("current_date", dateFormat.format(new Date()));
			PropertyConfigurator.configure("./src/main/resources/log4j.properties");
		}
//16
		//Extent Report - 1.
		public static String getSystemDate() 
		{
			DateFormat dateFormat = new SimpleDateFormat("_ddMMyyyy_HHmmss");
			Date date = new Date();
			return dateFormat.format(date);
		}

//17
		//Extent Report - 2.
		public static String getScreenshot(WebDriver driver) throws IOException 
		{
			    TakesScreenshot ts=(TakesScreenshot) driver;
				File src=ts.getScreenshotAs(OutputType.FILE);
				String path=System.getProperty("user.dir")+"/FailedTestsScreenshots/"+System.currentTimeMillis()+".png";
				File destination=new File(path);
				try 
				{
					FileUtils.copyFile(src, destination);
				} catch (IOException e) 
				{
					System.out.println("Capture Failed "+e.getMessage());
				}
				
				return path;
			}
//18
		//get all contacts from address book 
		public void getAllContacts(WebDriver driver)
		{
			 //int numOfRows = element.findElements(By.xpath("/html/body/div[6]/div[4]/div/div[20]/div[1]/table/thead")).size();
			 //int numOfColumns = driver.findElements(By.xpath("/html/body/div[6]/div[4]/div/div[20]/div[1]/table/tbody")).size();
			
			WebElement table = driver.findElement(By.xpath("/html/body/div[6]/div[4]/div/div[20]/div[1]/table")); 
			List<WebElement> allRows = table.findElements(By.tagName("tr")); 

			// And iterate over them, getting the cells 
			for (WebElement row : allRows) { 
			    List<WebElement> cells = row.findElements(By.tagName("td")); 

			    // Print the contents of each cell
			    for (WebElement cell : cells) { 
			        System.out.println(cell.getText());
			    }
		}
		}
}


