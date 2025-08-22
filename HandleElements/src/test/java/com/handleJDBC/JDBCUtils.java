package com.handleJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class JDBCUtils {
    Connection con;

    public Connection establishConnection() throws ClassNotFoundException, SQLException {
        Logger logger = LogManager.getLogger(JDBCUtils.class);

        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "Root@123";

        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, username, password);
        logger.info("Connection successful");

        return con;
    }

    public void closeConnection() {
        try {
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

