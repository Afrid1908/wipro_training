package com.pageFactory;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
	@Test
    public void verifyValidLogin() {
        // Step 1: Open login page and enter details
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("john");   
        loginPage.enterPassword("demo");   
        loginPage.clickLogin();

        // Step 2: Navigate to home page and get welcome text
        HomePage homePage = new HomePage(driver);
        String welcomeText = homePage.getWelcomeText();

        // Step 3: verify that login is successful
        Assert.assertTrue(welcomeText.contains("Welcome"),
            "Login failed - Welcome text not found!");
    }

}
