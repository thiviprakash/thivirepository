package com.TruckLogics.TestCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TruckLogics.Pages.AddressBook;
import com.TruckLogics.Pages.Load;
import com.TruckLogics.driverpec.TestBase;

public class AddressBookTest extends TestBase{
	AddressBook book;
	public AddressBookTest()
	{
		super();
	}
	@BeforeMethod
	  public void obj()
	  {
		book = new AddressBook();
	  }
	@Test
	  public void GetAllContacts() throws InterruptedException
	  {
		book.abmenu();
	    book.GetAllContacts();
	  }
}
