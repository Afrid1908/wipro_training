package com.testNGdemo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_Forloop {

	@DataProvider(name="loginData")
	public Object[][] loginTest(){
		int size=3;
		Object[][] data = new Object[size][2];
		
		for(int i=0;i<size;i++) {
			data[i][0]="admin";
			data[i][1]="admin123";
		}
		return data;
	}
	
	@Test(dataProvider="loginData")
	public void login(String username,String password) {
		System.out.println("Login with :"+username+" "+password);
	}
}
