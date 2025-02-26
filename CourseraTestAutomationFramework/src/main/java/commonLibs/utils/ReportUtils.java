package commonLibs.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportUtils {

	ExtentSparkReporter htmlReport;
	ExtentReports extentReports;
	ExtentTest extentTests;

	public ReportUtils(String reportFileName) {

		reportFileName = reportFileName.trim();

		htmlReport = new ExtentSparkReporter(reportFileName);

		extentReports = new ExtentReports();

		extentReports.attachReporter(htmlReport);
	}

	public void createATestCase(String testcaseName) {
		extentTests = extentReports.createTest(testcaseName);
	}

	public void addTestLog(Status status, String comment) {
		extentTests.log(status, comment);
	}

	public void flushReport() {

		extentReports.flush();
	}

	public void attachScreenshotToReport(String filename) {

		extentTests.addScreenCaptureFromPath(filename);

	}

}
