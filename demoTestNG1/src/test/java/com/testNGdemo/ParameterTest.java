package com.testNGdemo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class ParameterTest {

	WebDriver driver;
    WebDriverWait wait;

    @Parameters({"browserName","url"})
    @BeforeClass
    public void setUp(String browserName, String url) throws InterruptedException{
        switch (browserName) {
            case "Chrome":
                driver = new ChromeDriver();
                break;
            case "Edge":
                driver = new EdgeDriver();
                break;
            case "Firefox":
                driver = new FirefoxDriver();
                break;
            default:
            	System.out.println("Invalid Browser: " + browserName);
            	break;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Open site
        driver.get(url);
       
        // Login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_MainContent_username"))).sendKeys("Tester");
       
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        
        // Verify login
        Assert.assertTrue(driver.getTitle().contains("Web Orders"), "Login failed - Title mismatch");
        
    }
}
