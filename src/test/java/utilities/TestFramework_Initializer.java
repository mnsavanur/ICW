package utilities;

import org.testng.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;


public class TestFramework_Initializer implements IInvokedMethodListener, ITestListener, ISuiteListener {

    private int testLimit = 100;
    private int testCount = 0;

    protected static Utility_Initializer utils;
    protected LogAndReport_Util logReport;
    protected Screenshot_Util screenShot;
    private PageObject_Initializer pageObject_Util;

    public TestFramework_Initializer()
    {
    }

    private void runUtilityInitialization()
    {
        this.utils = new Utility_Initializer();
        this.logReport = this.utils.logReportUtil();
        this.screenShot = this.utils.screenShotUtil();
    }

    private void runPageObjectInitialization()
    {
        this.pageObject_Util = new PageObject_Initializer(this.utils);
    }

    private void refreshUtilitiesAndPageObjects()
    {
        this.utils.driverUtil().killWebDriverInstance();
        this.runUtilityInitialization();
        this.runPageObjectInitialization();
    }

    // This method can be used with @BeforeMethod TestNG Annotation to get the name of the test method for logging and
    // reporting purposes.  It can be used in place of the Test Listeners.
    private void getTestName(Method method)
    {
        String testName = method.getName();
        this.utils.reportUtil().beginReport(testName);
    }

    protected PageObject_Initializer whileViewing()
    {
        return this.pageObject_Util;
    }

    @BeforeClass
    public void initializeUtilities()
    {
        this.runUtilityInitialization();
    }

    @BeforeClass(dependsOnMethods = "initializeUtilities")
    public void initializePageObjects()
    {
        this.runPageObjectInitialization();
    }

   @AfterClass(alwaysRun = true)
    public void tearDownWebDriver()
    {
        this.utils.driverUtil().killWebDriverInstance();
    }

    @BeforeMethod
    public void checkTestCount(Method method)
    {
        if (this.testCount >= this.testLimit)
        {
            this.refreshUtilitiesAndPageObjects();
            this.testCount = 0;
        }
        else
        {
            this.testCount++;
        }
        System.out.println("TestCount: " + this.testCount);
    }

    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult)
    {
    }

    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult)
    {
    }

    public void onStart(ISuite iSuite)
    {
    }

    public void onFinish(ISuite iSuite)
    {
    }

    public void onTestStart(ITestResult iTestResult)
    {

        Object currentClass = iTestResult.getInstance();
        LogAndReport_Util logger = ((TestFramework_Initializer) currentClass).logReport;

        logger.reporting_Util.beginReport(iTestResult);
        logger.logging_Util.log_Info("Begin Test: " + iTestResult.getName());
    }

    public void onTestSuccess(ITestResult iTestResult)
    {

        Object currentClass = iTestResult.getInstance();
        Screenshot_Util screenShot = ((TestFramework_Initializer) currentClass).screenShot;
        LogAndReport_Util logger = ((TestFramework_Initializer) currentClass).logReport;
        logger.reporting_Util.endReport_PASS();
        logger.logging_Util.log_Info(iTestResult.getName() + " Status: PASSED");
    }

    public void onTestFailure(ITestResult iTestResult)
    {

        Object currentClass = iTestResult.getInstance();
        Screenshot_Util screenShot = ((TestFramework_Initializer) currentClass).screenShot;
        LogAndReport_Util logger = ((TestFramework_Initializer) currentClass).logReport;
        logger.takeScreenShotAndAttachToReport(screenShot.takeScreenshot());
        System.out.println("Failure screenshot listener worked");
        logger.reporting_Util.endReport_FAIL();
        logger.logging_Util.log_Info(iTestResult.getName() + " Status: FAILED");
    }

    public void onTestSkipped(ITestResult iTestResult)
    {

        // If a dependent test is skipped (based on the 'dependsOnMethods' TestNG attribute), casting the iTestResult
        // instance to get the logReportUtil field will not work (because the test method in question was never actually
        // executed).  So for now, there is a try/catch in place to catch the null pointer exception until a better
        // solution is found.  One way to avoid this would be to never use the 'dependsOnMethods' attribute in TestNG.
        // NOTE: a test can still be skipped, it just can't be skipped because it was never executed

        try
        {
            Object currentClass = iTestResult.getInstance();
            LogAndReport_Util logger = ((TestFramework_Initializer) currentClass).logReport;

            logger.reporting_Util.endReport_SKIP(iTestResult);
            logger.logging_Util.log_Info("Test SKIPPED");
        }
        catch (NullPointerException e)
        {
            System.err.println("Dependent test skipped: " + iTestResult.getName());
        }
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult)
    {
    }

    public void onStart(ITestContext iTestContext)
    {
    }

    public void onFinish(ITestContext iTestContext)
    {

    }

}