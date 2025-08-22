package com.handleElements;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.Assert;

//Alerts, Iframe, CheckBox, Windows/tabs
public class ElementTest2 extends BaseTestSetup{
	
//	@Test
//	public void testJavaScriptAlert() {
//		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
//		
//		//JS alert
//        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
//        Alert alert = driver.switchTo().alert();
//        Assert.assertEquals(alert.getText(), "I am a JS Alert");
//        alert.accept();
//        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains("You successfully clicked an alert"));
//        
//        //Js Confirm
//        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
//        alert = driver.switchTo().alert();
//        alert.dismiss();
//        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains("Cancel"));
//        
//        //JS prompt
//        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
//        alert = driver.switchTo().alert();
//        alert.accept();
//        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains("Hello")); 
//	}
	
	@Test
	public void testIFrame() {
	    driver.get("https://the-internet.herokuapp.com/iframe");

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // Switch to iframe when ready
	    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("mce_0_ifr"));

	    // Wait for the editor body to be present
	    WebElement editorBody = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tinymce")));

	    // Clear existing text and enter new text
	    editorBody.clear();
	    editorBody.sendKeys("Hello TinyMCE!");

	    // Get the typed text
	    String typedText = editorBody.getText();

	    // Validate
	    Assert.assertEquals(typedText, "Hello TinyMCE!", "iFrame text mismatch!");

	    // Switch back to main page
	    driver.switchTo().defaultContent();
	}


	
//	@Test
//	public void testMultipleWindows() {
//	    driver.get("https://the-internet.herokuapp.com/windows");
//
//	    // Store the parent window
//	    String parentWindow = driver.getWindowHandle();
//
//	    // Click link to open a new window
//	    driver.findElement(By.linkText("Click Here")).click();
//
//	    // Switch to child window
//	    for (String handle : driver.getWindowHandles()) {
//	        if (!handle.equals(parentWindow)) {
//	            driver.switchTo().window(handle);
//	            break;
//	        }
//	    }
//
//
//	    // Validate child window text
//	    String childHeading = driver.findElement(By.tagName("h3")).getText();
//	    Assert.assertEquals(childHeading, "New Window", "Child window text mismatch!");
//
//	    // Close child window
//	    driver.close();
//
//	    // Switch back to parent window
//	    driver.switchTo().window(parentWindow);
//
//	    // Validate parent window is still active
//	    String parentHeading = driver.findElement(By.tagName("h3")).getText();
//	    Assert.assertEquals(parentHeading, "Opening a new window", "Parent window text mismatch!");
//	}
	
}
