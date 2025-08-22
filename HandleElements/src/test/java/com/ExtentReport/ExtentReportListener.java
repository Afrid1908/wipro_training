package com.ExtentReport;

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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportListener implements ITestListener, ISuiteListener {
    private static ExtentReports extent;
    private static ExtentTest test;
    private WebDriver driver;

    @Override
    public void onStart(ISuite suite) {
        // Report file path
        String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport_" +
                new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".html";

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
        sparkReporter.config().setReportName("Automation Test Report");
        sparkReporter.config().setDocumentTitle("Test Results - Web Orders Demo");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        System.out.println("[REPORT INIT] ExtentReports created: " + reportPath);
    }

    @Override
    public void onTestStart(ITestResult result) {
        driver = new ChromeDriver(); // create driver for this test
        ExtentReportHolder.setDriver(driver);
        test = extent.createTest(result.getMethod().getMethodName());
        test.info("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed: " + result.getName());
        cleanUp();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail("Test Failed: " + result.getName());
        test.fail(result.getThrowable());

        // capture screenshot
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotPath = System.getProperty("user.dir") + "/screenshots/" +
                    result.getName() + "_" +
                    new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".png";
            File dest = new File(screenshotPath);
            dest.getParentFile().mkdirs();
            org.apache.commons.io.FileUtils.copyFile(src, dest);

            test.addScreenCaptureFromPath(screenshotPath, "Failure Screenshot");
        } catch (IOException e) {
            e.printStackTrace();
        }
        cleanUp();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("Test Skipped: " + result.getName());
        cleanUp();
    }

    @Override
    public void onFinish(ISuite suite) {
        extent.flush(); // write report to file
        System.out.println("[REPORT GENERATED] Extent report created successfully.");
    }

    private void cleanUp() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
