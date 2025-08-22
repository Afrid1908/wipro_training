package com.ListenerDemo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenerExample implements ITestListener, ISuiteListener{
	 private WebDriver driver;
	    private long testStartTime;

	    @Override
	    public void onStart(ISuite suite) {
	        // Suite launch
	        System.out.println("[SUITE START] " + suite.getName());
	        // You can send "suite started" email here if required
	    }

	    @Override
	    public void onFinish(ISuite suite) {
	        System.out.println("[SUITE END] " + suite.getName());
	        //here we can call 
	    }

	    @Override
	    public void onTestStart(ITestResult result) {
	        testStartTime = System.currentTimeMillis();
	        System.out.println("[START] " + result.getName());
	        driver = new ChromeDriver();
	        ListenerHolderExample.setDriver(driver);
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        long execTime = System.currentTimeMillis() - testStartTime;
	        System.out.println("[PASS] " + result.getName() + " (Time: " + execTime + " ms)");
	        cleanUp();
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        long execTime = System.currentTimeMillis() - testStartTime;
	        System.out.println("[FAIL] " + result.getName() + " (Time: " + execTime + " ms)");
	        takeScreenshot(result.getName());
	        cleanUp();
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        System.out.println("[SKIP] " + result.getName());
	        cleanUp();
	    }

	    private void takeScreenshot(String testName) {
	        try {
	            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	            String ts = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	            File dest = new File("screenshots/" + testName + "_" + ts + ".png");
	            dest.getParentFile().mkdirs();
	            org.apache.commons.io.FileUtils.copyFile(src, dest);
	            Reporter.log("<br><a href='" + dest.getAbsolutePath() + "'>Screenshot: " + testName + "</a><br>");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    private void cleanUp() {
	        if (driver != null) {
	            driver.quit();
	            driver = null;
	        }
	    }
}
