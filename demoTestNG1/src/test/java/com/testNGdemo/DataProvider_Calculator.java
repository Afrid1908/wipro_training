package com.testNGdemo;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_Calculator {
	@Test(dataProvider="testAdd")
	public void addition(int num1,int num2, int expectedSum) {
		int sum = num1 + num2;
		System.out.println("Sum of "+num1+" + "+num2+" = "+sum);
		Assert.assertEquals(sum, expectedSum, "Sum mismatch");
	}
	@DataProvider(name="testAdd")
	public Object[][] testAdd(){
		return new Object[][] {
			{5,5, 10},
			{10,2, 12},
			{999,111, 1110}
		};
	}
}
