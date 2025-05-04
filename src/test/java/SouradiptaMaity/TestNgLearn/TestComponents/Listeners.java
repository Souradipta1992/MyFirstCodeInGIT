package SouradiptaMaity.TestNgLearn.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Souradipta.AbstractClass.AbstractClass;
import Souradipta.Resources.testReporter;

public class Listeners implements ITestListener {

	testReporter reporter = new testReporter();
	ExtentReports reports = reporter.getReportObject();
	ThreadLocal<ExtentTest> extent = new ThreadLocal();

//	ExtentReports reports= testReporter.getReportObject();
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		extent.set(reports.createTest(result.getMethod().getMethodName()));
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		extent.get().pass("Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		extent.get().fail(result.getThrowable());		
		WebDriver driver = ((BaseTest) result.getInstance()).driver;
		try {
			String png = ((BaseTest) result.getInstance()).screenshot(result.getMethod().getMethodName());
			extent.get().addScreenCaptureFromPath(png);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		
//		String base64Screenshot = ((BaseTest) result.getInstance()).getBase64Screenshot();
//		extent.get().addScreenCaptureFromBase64String(base64Screenshot, result.getMethod().getMethodName());
//		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		reports.flush();
	}

}
