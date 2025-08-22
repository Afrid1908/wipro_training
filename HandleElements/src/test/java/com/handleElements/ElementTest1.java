package com.handleElements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import junit.framework.Assert;

//TextField, RadioButton, DropDown, File Upload, DatePicker
public class ElementTest1 extends BaseTestSetup{
//	@Test
//	public void testTextField() {
//		driver.get("https://demoqa.com/text-box");
//		
//		WebElement fullName = driver.findElement(By.id("userName"));
//		WebElement email = driver.findElement(By.id("userEmail"));
//		WebElement currAdd = driver.findElement(By.id("currentAddress"));
//		WebElement perAdd = driver.findElement(By.id("permanentAddress"));
//		WebElement submit = driver.findElement(By.id("submit"));
//		
//		fullName.sendKeys("Test user");
//		email.sendKeys("testuser@gmail.com");
//		currAdd.sendKeys("123 current address");
//		perAdd.sendKeys("456 permanent address");
//		submit.click();
//		
//		WebElement outputName = driver.findElement(By.id("output"));
//		Assert.assertTrue(outputName.getText().contains("Test user"));
//	}
//	
//	@Test
//	public void testRadioButton() {
//        driver.get("https://demoqa.com/radio-button");
//        
//        WebElement yesLabel = driver.findElement(By.cssSelector("label[for='yesRadio']"));
//        yesLabel.click();
//        
//        WebElement result = driver.findElement(By.className("text-success"));
//        Assert.assertEquals(result.getText(), "Yes");
//	}
	
//	@Test
//	public void testDatePicker() {
//		driver.get("https://demoqa.com/date-picker");
//		
//		WebElement dateInput = driver.findElement(By.id("datePickerMonthYearInput"));
//		dateInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
//		dateInput.sendKeys(Keys.DELETE);
//		dateInput.sendKeys("08/18/2025");
//		dateInput.sendKeys(Keys.ENTER);
//		Assert.assertTrue(dateInput.getAttribute("value").contains("08/18/2025"));
//	}
	
	@Test
	public void testFileUpload() throws IOException {
		driver.get("https://demoqa.com/upload-download");
		
		//creating temporary file to upload
		File temp = File.createTempFile("demo-temp", ".txt");
		try (FileWriter wt = new FileWriter(temp)){
			wt.write("Hello from selenium!!!");
		}
		WebElement fileUpload = driver.findElement(By.id("uploadFile"));
		fileUpload.sendKeys(temp.getAbsolutePath());
		
		WebElement path = driver.findElement(By.id("uploadedFilePath"));
		Assert.assertTrue(path.getText().contains(temp.getName()));		
	}
	
	@Test
	public void testDropDown() {
		driver.get("https://demoqa.com/select-menu");
		WebElement oldSelect = driver.findElement(By.id("oldSelectMenu"));
		Select select = new Select(oldSelect);
		select.selectByVisibleText("Green");
		Assert.assertEquals(select.getFirstSelectedOption().getText(),"Green");
	}
}
