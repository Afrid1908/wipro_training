package com.pom;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
	@Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterUsername("Tester");  
        loginPage.enterPassword("test");    
        loginPage.clickLogin();
        
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Web Orders"), "Login likely failed - Title: " + title);
    }
}
