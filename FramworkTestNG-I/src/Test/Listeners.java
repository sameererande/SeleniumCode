package Test;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
//To implement listener in testng there is a interface for that.(ITestListener)
	@Override
	public void onTestStart(ITestResult result) {
		
	}
	@Override
	public void onTestSuccess(ITestResult result) {
	   System.out.println("I successfully executed listeners Pass code");	
	}
	@Override
	public void onTestFailure(ITestResult result) {
		//Write screenshot code here of test failure
		System.out.println("Failed listeners Pass code" +result.getName());
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	@Override
	public void onStart(ITestContext context) {
		
	}
	@Override
	public void onFinish(ITestContext context) {
		
	}
}
