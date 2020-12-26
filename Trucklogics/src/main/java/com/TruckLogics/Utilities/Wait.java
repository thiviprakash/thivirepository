package com.TruckLogics.Utilities;

import com.pageload.Pageload;

public class Wait {
	public static void staticShortWait()
	{
		try 
		{
			Thread.sleep(Pageload.SHORT_WAIT);
		} 
		catch(InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void staticMediumWait()
	{
		try 
		{
			Thread.sleep(Pageload.MEDIUM_WAIT);
		} 
		catch(InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void staticLongWait()
	{
		try 
		{
			Thread.sleep(Pageload.LONG_WAIT);
		} 
		catch(InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
}
