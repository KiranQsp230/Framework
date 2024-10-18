package practice;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ToCreateExtentReports {

	public static void main(String[] args) {

		ExtentSparkReporter htmlreport = new ExtentSparkReporter(".\\ExtentReports\\report");
		
		
		ExtentReports report = new ExtentReports();
		report.attachReporter(htmlreport);
		
		ExtentTest test = report.createTest("DEMO");
		report.flush();
		
	}

}
