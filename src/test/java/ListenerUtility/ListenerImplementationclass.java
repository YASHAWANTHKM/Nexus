package ListenerUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BaseUtility.BaseClass;
import UtilityClassObject.UtilityclassObjectClass;

public class ListenerImplementationclass implements ITestListener, ISuiteListener {
	public ExtentReports report;
	public static ExtentTest test;

	/**
	 * to remove space and : we have to use replace twice
	 */
	String Time = new Date().toString().replace(" ", "_").replace(":", "_");

	@Override
	public void onStart(ISuite suite) {

		System.out.println("Report configuration");
		// report config
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/Report" + Time + ".html");
		spark.config().setDocumentTitle("Nexus Automation Suite Results");
		spark.config().setReportName("Nexus Report");
		spark.config().setTheme(Theme.DARK);
		// add env info and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "MacBook Pro");
		report.setSystemInfo("BROWSER", "chrome");
	}

	@Override
	public void onFinish(ISuite suite) {

		System.out.println("Report Backup");
		// take backup
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {

		System.out.println("======" + result.getMethod().getMethodName() + "==Start===");
		test = report.createTest(result.getMethod().getMethodName());
		UtilityclassObjectClass.setTest(test);
		UtilityclassObjectClass.getTest().log(Status.INFO, result.getMethod().getMethodName() + "===>STARTED====>");
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		System.out.println("======" + result.getMethod().getMethodName() + "==End===");
		UtilityclassObjectClass.getTest().log(Status.PASS, result.getMethod().getMethodName() + "====>COMPLETED====>");

	}

	@Override
	public void onTestFailure(ITestResult result) {

		String TestcaseName = result.getMethod().getMethodName();
		TakesScreenshot edriver = (TakesScreenshot) BaseClass.sdriver;

		System.out.println(TestcaseName);
		System.out.println(edriver);

		String filepath = edriver.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(filepath, TestcaseName + Time);
		UtilityclassObjectClass.getTest().log(Status.FAIL, result.getMethod().getMethodName() + "====>FAILED===>");
		UtilityclassObjectClass.getTest().log(Status.FAIL, result.getThrowable());

	}

	@Override
	public void onTestSkipped(ITestResult result) {

		UtilityclassObjectClass.getTest().log(Status.SKIP, result.getMethod().getMethodName() + "====>SKIPPED===>");

		UtilityclassObjectClass.getTest().log(Status.SKIP, result.getThrowable());

	}

}
