package com.testNGdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_Form {
	WebDriver driver;
	
	@Test(dataProvider="Form")
	public void register(String gender,String firstName,String lastName,String email,String password) throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/register");
		
		//select gender
		if(gender.equalsIgnoreCase("Male")) {
			driver.findElement(By.id("gender-male")).click();
			
			driver.findElement(By.id("FirstName")).sendKeys(firstName);
			driver.findElement(By.id("LastName")).sendKeys(lastName);
			driver.findElement(By.id("Email")).sendKeys(email);
			driver.findElement(By.id("Password")).sendKeys(password);
			driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
			//submiting form
			driver.findElement(By.id("register-button")).click();
			Thread.sleep(5000);//wait until register
			System.out.println("Form submitted "+firstName+" "+lastName+" "+" ( "+gender+" )");
			driver.quit();
		}
		else{
			driver.findElement(By.id("gender-female")).click();	  
			driver.findElement(By.id("FirstName")).sendKeys(firstName);
			driver.findElement(By.id("LastName")).sendKeys(lastName);
			driver.findElement(By.id("Email")).sendKeys(email);
			driver.findElement(By.id("Password")).sendKeys(password);
			driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
			//submiting form
			driver.findElement(By.id("register-button")).click();
			Thread.sleep(5000);//wait until register
			System.out.println("Form submitted "+firstName+" "+lastName+" "+" ( "+gender+" )");
			driver.quit();
		}
		
	}
		@DataProvider(name="Form")
		public Object[][] Form(){
			  return new Object[][] {
				  {"Female", "Sara", "Doe", "sara_demo2@test.com", "sara123"},
				  {"Male", "Bob", "Johnson", "bob_demo3@test.com", "bob123"},
		          {"Male", "John", "Doe", "john_demo1@test.com", "pass123"}
		       };
	}
}
