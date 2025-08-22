package com.ExcelIntegration;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelTest {
	WebDriver driver;
	int rowCount=1; //start from row 1 (row 0 is header so ignoring that)
	
	@BeforeClass
	public void setup() throws IOException {
		driver = new ChromeDriver();
		ExcelUtils.loadExcel("C://Users/Admin/Desktop/Wipro_Training/LoginData.xlsx", "LoginData");
	}
	
	@DataProvider(name="loginData")
	public Object[][] getData(){
		int rowCount = ExcelUtils.getRowCount();
		Object[][] data = new Object[rowCount][2];
		
		for(int i=1; i<=rowCount; i++) {
			data[i-1][0] = ExcelUtils.getCellData(i, 0);  //username
			data[i-1][1] = ExcelUtils.getCellData(i, 1);  //password
		}
		return  data;
	}
	
	@Test(dataProvider="loginData")
	public void testLogin(String username, String password) throws IOException {
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(username);
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(password);
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		
		boolean status = driver.getPageSource().contains("Welcome");
		
		if(status) {
			ExcelUtils.writeResult(rowCount, 2, "Pass");
		}else {
			ExcelUtils.writeResult(rowCount, 2, "Fail");
		}
		rowCount++;
	}
	
	@AfterClass
	public void tearDown() throws IOException {
		if(driver != null) {
			driver.quit();
		}
		ExcelUtils.closeWorkbook();
	}
	
	
}
