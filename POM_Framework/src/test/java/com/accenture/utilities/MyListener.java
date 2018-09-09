package com.accenture.utilities;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class MyListener implements ITestListener{
	ExtentReports report;
	ExtentTest test;

	public void onFinish(ITestContext result) {
		//System.out.println("On Test Finish");
		report.endTest(test);
		report.flush();
	}

	public void onStart(ITestContext result) {
		//System.out.println("On TestNG Start");
		report = new ExtentReports(".\\MyTestResult\\TestResultReport.html");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailure(ITestResult result) {
		test.log(LogStatus.FAIL,result.getMethod().getMethodName()+" has failed");
		//System.out.println("On Test Failure");
	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestStart(ITestResult result) {
		test=report.startTest(result.getMethod().getMethodName()+" has started");
		//System.out.println("On Test Start");
	}

	public void onTestSuccess(ITestResult result) {
		test.log(LogStatus.PASS,result.getMethod().getMethodName()+" has passed");
		//System.out.println("On Test Success");
	}	
}