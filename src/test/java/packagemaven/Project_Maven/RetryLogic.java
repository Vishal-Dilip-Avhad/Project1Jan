package packagemaven.Project_Maven;

import org.testng.IRetryAnalyzer;

import org.testng.ITestResult;

public class RetryLogic implements IRetryAnalyzer {
	int initialCount = 0;
	int retrytimes = 1;

	@Override
	public boolean retry(ITestResult result) {
		if (initialCount < retrytimes) {
			initialCount++;
			return true;
		}

		return false;
	}
}
