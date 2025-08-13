package com.testNGdemo;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestFlipkartWishlist {
	 WebDriver driver;
	    WebDriverWait wait;

	    @BeforeClass
	    public void setup() {
	        driver = new ChromeDriver();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	        driver.manage().window().maximize();
	        driver.get("https://www.flipkart.com/");
	    }

	    @Test(priority = 1)
	    public void loginWithManualOTP() throws Exception {
	        // Click Login
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Login']"))).click();

	        // Enter mobile number
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input._2IX_2-"))).sendKeys("8956605173");

	        // Click Request OTP
	        driver.findElement(By.xpath("//span[text()='Request OTP']")).click();

	        // Wait for OTP entry (manual step)
	        System.out.println("Please enter OTP manually on Flipkart and then press ENTER in console...");
	        System.in.read(); // Wait until you press Enter

	        // Wait until login is successful (account name appears)
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='My Account']")));
	        System.out.println("Login successful!");
	    }

	    @Test(priority = 2)
	    public void addProductToWishlist() {
	        // Search for product
	        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
	        searchBox.clear();
	        searchBox.sendKeys("iPhone 15");
	        driver.findElement(By.cssSelector("button[type='submit']")).click();

	        // Wait for search results
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a._1fQZEK, a._2UzuFa")));

	        // Click first product
	        WebElement firstProduct = driver.findElement(By.cssSelector("a._1fQZEK, a._2UzuFa"));
	        String originalWindow = driver.getWindowHandle();
	        firstProduct.click();

	        // Switch to new tab
	        wait.until(driver -> driver.getWindowHandles().size() > 1);
	        Set<String> windows = driver.getWindowHandles();
	        for (String handle : windows) {
	            if (!handle.equals(originalWindow)) {
	                driver.switchTo().window(handle);
	                break;
	            }
	        }

	        // Click Add to Wishlist
	        WebElement wishlistBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Add to Wishlist']")));
	        wishlistBtn.click();

	        // Verify confirmation
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Added to Wishlist')]")));
	        System.out.println("Product added to wishlist successfully!");
	    }

	    @Test(priority = 3)
	    public void validateWishlistContent() {
	        // Navigate to Wishlist
	        driver.get("https://www.flipkart.com/wishlist?link=home_wishlist");

	        // Wait for wishlist to load
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Wishlist')]")));

	        // Check if product is present
	        boolean productPresent = driver.findElements(By.xpath("//a[contains(text(),'iPhone 15')]")).size() > 0;
	        Assert.assertTrue(productPresent, "Product not found in wishlist!");
	        System.out.println("Wishlist validation successful!");
	    }


    @AfterMethod
    public void afterMethod() {
        System.out.println("Method execution completed");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Closing browser");
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test execution");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("End of suite");
    }
}
