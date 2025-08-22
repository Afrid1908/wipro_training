package com.ExtentReport;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

@Listeners(ExtentReportListener.class)
public class WebOrdersTest {

    @Test
    public void validLoginTest() {
        WebDriver driver = ExtentReportHolder.getDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

        Assert.assertTrue(driver.getTitle().contains("Web Orders"), "Login failed!");
    }

    @Test
    public void invalidLoginTest() {
        WebDriver driver = ExtentReportHolder.getDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("wrongUser");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("wrongPass");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

        Assert.assertTrue(driver.getTitle().contains("Web Orders"), "Expected failure not handled");
    }
}