package vtiger.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener {

	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname + "Passed");

		test = report.createTest(methodname);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname + "Passed");

		test.log(Status.PASS, methodname + "----Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		JavaUtility jutil = new JavaUtility();
		WebDriverUtility wutil = new WebDriverUtility();
		String methodname = result.getMethod().getMethodName();
		test.log(Status.FAIL, methodname + "---Failed");
		test.log(Status.INFO, result.getThrowable());

		String screenshot = methodname + "-" + jutil.getSystemDateInFormat();
		try {
			String path = wutil.toTakeScreenshot(BaseClass.sDriver, screenshot);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(methodname + "Fail");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname + "Skipped");
		test.log(Status.SKIP, methodname + "---Skipped");
		test.log(Status.INFO, result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("---Suite execution Started---");
		// Create obj of ExtententSparkReporter
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(
				".\\ExtentReports\\Report-" + new JavaUtility().getSystemDateInFormat() + ".html");
		htmlReport.config().setDocumentTitle("vtiger Execution Reports");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("VTIGER EXECUTION REPORT");

		// Create obj ExtentReporters
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("BaseURL", "http://localhost:8888");
		report.setSystemInfo("BaseBrowser", "Chrome");
		report.setSystemInfo("Reporter Name", "Kiran");

	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("---Suite execution Finished---");
		report.flush();
	}

}
