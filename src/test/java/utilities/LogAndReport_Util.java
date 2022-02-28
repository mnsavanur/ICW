package utilities;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LogAndReport_Util {

    Logging_Util logging_Util;
    Reporting_Util reporting_Util;

    public LogAndReport_Util(Logging_Util log_util, Reporting_Util report_Util) {
        this.logging_Util = log_util;
        this.reporting_Util = report_Util;
    }

    public void writeTo_Log(String log) {
        logging_Util.log_Info(log);
    }

    public void writeTo_Report(String info) {
        ExtentTest report = reporting_Util.getActiveReport();
        report.log(LogStatus.INFO, info);
    }

    public void writeTo_LogAndReport(String info) {
        writeTo_Log(info);
        writeTo_Report(info);
    }

    public void writeTo_LogAndReport_Pass(String info) {
        writeTo_Log(info);
        ExtentTest report = reporting_Util.getActiveReport();
        report.log(LogStatus.PASS, info);
    }

    public void writeTo_LogAndReport_Fail(String info) {
        writeTo_Log(info);
        ExtentTest report = reporting_Util.getActiveReport();
        report.log(LogStatus.FAIL, info);
    }

    public void writeTo_LogAndReport_Warning(String info)
    {
        writeTo_Log(info);
        ExtentTest report = reporting_Util.getActiveReport();
        report.log(LogStatus.WARNING, info);
    }

    public void takeScreenShotAndAttachToReport(String screenShotLocation) {
        this.reporting_Util.addScreenshot(screenShotLocation);
    }
}
