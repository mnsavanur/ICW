package utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestResult;

public class Reporting_Util {

    private ExtentReports extentReport;
    private ExtentTest extentTest;

    // Leaving config utility in the constructor in case it is needed later on for multi-threading purposes
    public Reporting_Util(ExtentReports extentReport) {
        this.extentReport = extentReport;
        System.out.println("Reporting Util hit");
    }

    // Overloaded method for use with onTestStart ITestResult interface. Will provide test method name to the extentTest
    public void beginReport(ITestResult iTestResult) {
        this.extentTest = this.extentReport.startTest("Test: " + iTestResult.getName());
    }

    // Overloaded method for use with @BeforeMethod TestNG annotation. Will provide test method name to the extentTest
    public void beginReport(String methodName) {
        this.extentTest = this.extentReport.startTest("Test: " + methodName);
    }

    public void endReport() {
        this.extentReport.endTest(this.extentTest);
        this.extentReport.flush();
    }

    public void fail(String fail) {
        extentTest.log(LogStatus.FAIL, fail);
    }

    public void endReport_PASS() {
        this.extentTest.log(LogStatus.PASS, "Test Passed");
        this.extentReport.endTest(this.extentTest);
        this.extentReport.flush();
    }

    public void endReport_FAIL() {
        this.extentTest.log(LogStatus.FAIL, "Test Failed");
        this.extentReport.endTest(this.extentTest);
        this.extentReport.flush();
    }

    public void endReport_SKIP(ITestResult iTestResult) {
        this.extentTest.log(LogStatus.SKIP, "Skipped test: " + iTestResult.getName());
        this.extentReport.endTest(this.extentTest);
        this.extentReport.flush();
    }

    public void addScreenshot(String screenShotLocation) {
        this.extentTest.log(LogStatus.INFO, "Screenshot: " + this.extentTest.addScreenCapture(screenShotLocation));
    }

    public ExtentTest getActiveReport() {
        return this.extentTest;
    }
}
