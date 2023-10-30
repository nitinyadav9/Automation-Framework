package module1.testcomponent;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import automation.resources.ExtentReportNG;

public class Listeners extends BaseTest implements ITestListener {
	
	
	ExtentReports extent = ExtentReportNG.getReportObject();
	ExtentTest test;
	
	@Override
	public void onFinish(ITestContext contextFinish) {
	System.out.println("onFinish method finished");
	
	extent.flush();
	
	

	}

	@Override
	public void onStart(ITestContext contextStart) {
//	System.out.println("onStart method started");
	System.getProperty("user.dir");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//	System.out.println("Method failed with certain success percentage"+ result.getName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
//	System.out.println("Method failed"+ result.getName());
	
	String path= null;
	try {
		path = takeScreenshot(result.getMethod().getMethodName());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	test.addScreenCaptureFromPath(path);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
//	System.out.println("Method skipped"+ result.getName());

	}

	@Override
	public void onTestStart(ITestResult result) {
//	System.out.println("Method started"+ result.getName());
	test = extent.createTest(result.getMethod().getMethodName());
	
	

	}

	@Override
	public void onTestSuccess(ITestResult result) {
//	System.out.println("Method passed"+ result.getName());
	test.pass("pass");
	String path= null;
	try {
		path = takeScreenshot(result.getMethod().getMethodName());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	test.addScreenCaptureFromPath(path);
	}

	
	
}
