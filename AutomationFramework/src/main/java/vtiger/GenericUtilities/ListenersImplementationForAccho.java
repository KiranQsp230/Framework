package vtiger.GenericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersImplementationForAccho implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"---Started--");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"---Passed--");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"---Failed--");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"---Skipped--");
	}

	@Override
	public void onStart(ITestContext context) {
	
		System.out.println("---Suite Execution Started---");
	}

	@Override
	public void onFinish(ITestContext context) {
	System.out.println("---Suite Execution Finished---");
	}

	
}
