package pageobjects;

import org.openqa.selenium.By;
import utilities.Browser_Util;
import utilities.LogAndReport_Util;
import utilities.Screenshot_Util;
import utilities.VideoRecorder_Util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CMPLogin_Page {

    private Browser_Util browserUtil;
    private LogAndReport_Util log;
    private Screenshot_Util ss;
    private LoginMethods pageMethods;

    public CMPLogin_Page(LogAndReport_Util logAndReport, Screenshot_Util screenshot, Browser_Util browser_Util) {
        this.browserUtil = browser_Util;
        this.log = logAndReport;
        this.ss = screenshot;
        this.pageMethods = new LoginMethods();
    }

    public interface ILogin {
        String page = "Application";
        List lp_username_text = Arrays.asList(By.id("Text1"), page, "User Name");
        List lp_password_text = Arrays.asList(By.id("Password1"), page, "Password");
        List lp_submit_button = Arrays.asList(By.id("btnLogin"), page, "Submit Button");
    }

    public class LoginMethods implements CMPLogin_Page.ILogin {

        public void logsIntoPolicyDecisions(String pdURL, String userName, String password )  {
            browserUtil.navigatesToURLAndVerifiesPageTitle(pdURL, page);
            browserUtil.waitUntilPleaseWaitDisappear();

            browserUtil.entersTextWithTabIn(lp_username_text, userName);
            browserUtil.entersTextWithTabIn(lp_password_text, password);
            browserUtil.clicksWebElement(lp_submit_button);
        }

        public void StartRecording(String TestCaseId) throws Exception {
            VideoRecorder_Util.startRecord(TestCaseId);
        }


        /*public void RatelogsIntoPolicyDecisions(String pdURL, String userName, String password) {
            browserUtil.navigatesToURLAndVerifiesPageTitle(pdURL, page);
            browserUtil.waitUntilPleaseWaitDisappear();

            if (browserUtil.getDriver().getCurrentUrl().equalsIgnoreCase(pdURL)) {
                browserUtil.entersTextWithTabIn(lp_username_text, userName);
                browserUtil.entersTextWithTabIn(lp_password_text, password);
                browserUtil.clicksWebElement(lp_submit_button);
            } else {
                this.logOut();
                browserUtil.waitUntilPleaseWaitDisappear();
                browserUtil.navigatesToURLAndVerifiesPageTitle(pdURL, page);
                browserUtil.entersTextWithTabIn(lp_username_text, userName);
                browserUtil.entersTextWithTabIn(lp_password_text, password);
                browserUtil.clicksWebElement(lp_submit_button);
            }

        }*/

        public void logOut()  {
            browserUtil.driver.findElement(By.xpath("//a/span[text()='Signoff']")).click();
            browserUtil.waitUntilPleaseWaitDisappear();
        }
    }


    public Browser_Util theUser() {
        return this.browserUtil;
    }

    public LoginMethods theUser_() {
        return this.pageMethods;
    }

}