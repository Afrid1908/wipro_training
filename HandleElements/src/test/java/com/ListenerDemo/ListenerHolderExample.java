package com.ListenerDemo;

import org.openqa.selenium.WebDriver;

public class ListenerHolderExample {
	  	private static WebDriver driver;
	    public static void setDriver(WebDriver d) { driver = d; }
	    public static WebDriver getDriver() { return driver; }
}
