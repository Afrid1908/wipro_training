package com.handleJDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestJDBC {
    WebDriver driver;
    Connection con;
    Statement stmt;
    ResultSet rs;
    JDBCUtils jdbcUtil = new JDBCUtils();

    @BeforeClass
    public void setup() throws ClassNotFoundException, SQLException {
        con = jdbcUtil.establishConnection();
        stmt = con.createStatement();
        driver = new ChromeDriver();
    }

    @Test
    public void testData() throws SQLException {
        String query = "SELECT * FROM users";
        rs = stmt.executeQuery(query);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        while (rs.next()) {
            String username = rs.getString("username");
            String password = rs.getString("password");

            driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_MainContent_username")));
            driver.findElement(By.id("ctl00_MainContent_username")).clear();
            driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(username);
            driver.findElement(By.id("ctl00_MainContent_password")).clear();
            driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(password);
            driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        }
    }

    @AfterClass
    public void tearDown() throws SQLException {
        if (rs != null) rs.close();
        if (stmt != null) stmt.close();
        jdbcUtil.closeConnection();
        
        if (driver != null) 
        	driver.quit();
    }
}

	
