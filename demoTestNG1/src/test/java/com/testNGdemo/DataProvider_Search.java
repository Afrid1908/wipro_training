package com.testNGdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_Search {
	WebDriver driver;
	
	@Test(dataProvider="searchTest")
	public void search(String searchData) throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys(searchData);
		driver.findElement(By.name("q")).submit();
		Thread.sleep(5000);
		System.out.println("Search completed for: "+searchData);
		driver.quit();
	}
	
	@DataProvider(name="searchTest")
	public Object[][] searchTest(){
		return new Object[][] {
			{"selenium"},{"testng"},{"automation"}
		};
	}
}
