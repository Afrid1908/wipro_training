package com.ListenerDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerExample.class)
public class WebOrdersTest {
	@Test(retryAnalyzer = RetryAnalyzerExample.class)
    public void loginTest() {
        WebDriver driver = ListenerHolderExample.getDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Web Orders"), "Login failed or unexpected title: " + title);
    }
}
