package com.ExtentReport;

import org.openqa.selenium.WebDriver;

public class ExtentReportHolder {
	private static WebDriver driver;
    public static void setDriver(WebDriver d) { driver = d; }
    public static WebDriver getDriver() { return driver; }
}
