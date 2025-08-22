package com.ListenerDemo;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerExample implements IRetryAnalyzer{
	private int retryCount = 0;
    private static final int maxRetryCount = 2;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            System.out.println("[RETRY] " + result.getName() + " - Count: " + retryCount);
            return true;
        }
        return false;
    }

}
