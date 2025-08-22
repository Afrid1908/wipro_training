package com.parallelExecution;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class ParallelExecutionDemo {

    @DataProvider(name = "userData", parallel = true)
    public Object[][] getData() {
        return new Object[][] {
                {"Tester", "test"}
        };
    }

    private WebDriver launchAndLogin(String username, String password) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_MainContent_username"))).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_MainContent_password"))).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_MainContent_login_button"))).click();
        //here we verify login 
        Assert.assertTrue(driver.getTitle().contains("Web Orders"), "Login failed");
        return driver;
    }

    @Test(dataProvider = "userData", invocationCount = 2, threadPoolSize = 2)
    public void loginTest(String username, String password) {
        WebDriver driver = launchAndLogin(username, password);
        System.out.println("Thread " + Thread.currentThread().getId() + " - Login successful");
        driver.quit();
    }

    @Test(dataProvider = "userData", invocationCount = 2, threadPoolSize = 2)
    public void viewAllProducts(String username, String password) {
        WebDriver driver = launchAndLogin(username, password);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productsLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("View all products")));
        productsLink.click();
        
        //verify products page loaded/showing proper data
        Assert.assertTrue(driver.getPageSource().contains("List of Products"), "Products page not loaded");
        System.out.println("Thread " + Thread.currentThread().getId() + " - Viewed Products");
        driver.quit();
    }

    @Test(dataProvider = "userData", invocationCount = 2, threadPoolSize = 2)
    public void viewAllOrders(String username, String password) {
        WebDriver driver = launchAndLogin(username, password);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement orderList = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("View all orders")));
        orderList.click();
        
        //verify orders page loaded/showing proper data
        Assert.assertTrue(driver.getPageSource().contains("List of Orders"), "Orders page not loaded");
        System.out.println("Thread " + Thread.currentThread().getId() + " - Viewed Orders");
        driver.quit();
    }
}
