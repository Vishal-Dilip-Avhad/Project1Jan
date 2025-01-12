package packagemaven.Project_Maven;

import java.io.File;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listeners_Logic implements ITestListener {
	static WebDriver driver;

	@Override
	public void onTestStart(ITestResult result) {

		ITestListener.super.onTestStart(result);
		Reporter.log("Test case is started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		ITestListener.super.onTestSuccess(result);
		Reporter.log("Test case is  passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		ITestListener.super.onTestFailure(result);
		Reporter.log("Test case is failed");

		try {

			TakesScreenshot t1 = (TakesScreenshot) driver;
			File src = t1.getScreenshotAs(OutputType.FILE);
			File dest = new File(
					"C:\\Users\\asus\\eclipse-workspace\\SeleniumByMKT\\screenshots\\photo" + Math.random() + ".png");
			// File dest = new
			// File("C:\\Users\\asus\\eclipse-workspace\\SeleniumByMKT\\screenshots\\photo"+new
			// screenshot().getClass()+".png");

			FileHandler.copy(src, dest);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		ITestListener.super.onTestSkipped(result);
		Reporter.log("Test case is skipped");
	}

}
