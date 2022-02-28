package utilities;

import com.relevantcodes.extentreports.ExtentReports;
import org.openqa.selenium.WebDriver;

public class Utility_Initializer
{

    private WebDriver_Util driverUtil;
    private Logging_Util loggingUtil;
    private Reporting_Util reportingUtil;
    private LogAndReport_Util logReportUtil;
    private ConfigReader_Util configReader;
    private ExcelFile_Util excelFileUtil;
    private Screenshot_Util screenShotUtil;
    private Browser_Util browserUtil;
    private Base_Util baseUtil;
    private Synchronization_Util synchronizationUtil;
    private TestAssist_Utility testAssistUtility;

    public Utility_Initializer()
    {
        this.configReader = new ConfigReader_Util();
        this.loggingUtil = new Logging_Util(this.configReader);
        this.driverUtil = new WebDriver_Util(this.configReader);
        WebDriver browserDriver = this.driverUtil.createAndRetrieveWebDriverInstance();
        this.screenShotUtil = new Screenshot_Util(browserDriver, this.configReader);
        ExtentReports extentReports = new ExtentReports(this.configReader.getExtentFilePath(), false);
        this.reportingUtil = new Reporting_Util(extentReports);
        this.logReportUtil = new LogAndReport_Util(this.loggingUtil, this.reportingUtil);
        this.browserUtil = new Browser_Util(browserDriver, this.screenShotUtil, this.logReportUtil);
        this.excelFileUtil = new ExcelFile_Util();
        this.baseUtil=new Base_Util(browserDriver, this.screenShotUtil, this.logReportUtil,this.browserUtil);
        this.synchronizationUtil = new Synchronization_Util(browserDriver);
        this.testAssistUtility = new TestAssist_Utility();
    }

    public ConfigReader_Util configReader() {
        return this.configReader;
    }

    public ExcelFile_Util excelFileUtil() {
        return this.excelFileUtil;
    }

    public Logging_Util logUtil() {
        return this.loggingUtil;
    }

    public Reporting_Util reportUtil() {
        return this.reportingUtil;
    }

    public LogAndReport_Util logReportUtil() {
        return this.logReportUtil;
    }

    public Screenshot_Util screenShotUtil() {
        return this.screenShotUtil;
    }

    public WebDriver_Util driverUtil() {
        return this.driverUtil;
    }

    public Browser_Util browserUtil() {
        return this.browserUtil;
    }

    public Base_Util baseUtil() {
        return this.baseUtil;
    }

    public Synchronization_Util syncUtil() {
        return this.synchronizationUtil;
    }

    public TestAssist_Utility testAssistUtility() {
        return this.testAssistUtility;
    }

}