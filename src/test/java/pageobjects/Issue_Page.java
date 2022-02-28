package pageobjects;

import org.openqa.selenium.By;
import utilities.Base_Util;
import utilities.Browser_Util;
import utilities.LogAndReport_Util;
import utilities.Screenshot_Util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Issue_Page
{
    private Base_Util baseUtil;
    private Browser_Util browserUtil;
    private LogAndReport_Util log;
    private Screenshot_Util ss;
    private Issue_Page.IssuePageMethods pageMethods;

    public Issue_Page(LogAndReport_Util logAndReport, Screenshot_Util screenshot, Browser_Util browser_Util, Base_Util base_util)
    {
        this.browserUtil = browser_Util;
        this.baseUtil = base_util;
        this.log = logAndReport;
        this.ss = screenshot;
        this.pageMethods = new Issue_Page.IssuePageMethods();
    }

    public interface IIssue_Page
    {
        List ip_Issue_Button = Arrays.asList(By.id("CoCommitHTML_cmdCommit"), "Issue Page", "Issue_Button");
        List ip_Next_Button = Arrays.asList(By.xpath("//button[@title='Next']"),"Issue Page", "Issue_Button");
        By ip_issue_Label = By.id("CoCommitHTML_lblCommit");
        String pageName = "Issue_Options";
        List rp_regeneratestatisticalcoding_CheckBox = Arrays.asList(By.xpath("//label[text()='Regenerate Statistical Coding']/preceding::input[@type='checkbox'][1]"), pageName,"Regenerate Statistical Coding checkBox");
        List rp_regeneratepolicywriting_CheckBox = Arrays.asList(By.xpath("//label[text()='Regenerate Policy Writing']/preceding::input[@type='checkbox'][1]"), pageName,"Regenerate Policy Writing checkBox");

    }

    public class IssuePageMethods implements Issue_Page.IIssue_Page
    {

        public void convertToIssue()
        {

            baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("CONVERTS TO ISSUE");
            browserUtil.waitUntilPleaseWaitDisappear();
            browserUtil.clicksWebElement(ip_Next_Button);
            browserUtil.waitUntilPleaseWaitDisappear();
        }

        public void issuePolicy() throws InterruptedException
        {
            baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("ISSUE");
            browserUtil.waitUntilPleaseWaitDisappear();
            browserUtil.waitsUntilWebElementIsClickable(ip_Issue_Button);
            browserUtil.clicksWebElement(ip_Issue_Button);
            browserUtil.waitUntilPleaseWaitDisappear();
        }

        public void checkAndIssuePolicy(Map<String, List<String>> map) throws InterruptedException
        {
            baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("ISSUE");
            browserUtil.waitUntilPleaseWaitDisappear();

            if(map.get("Regenerate_Statistical_Coding_Flag").get(0).equalsIgnoreCase("Yes") || map.get("Regenerate_Statistical_Coding_Flag").get(0).equalsIgnoreCase("Check"))
            {
                browserUtil.setsCheckBoxTo(true, rp_regeneratestatisticalcoding_CheckBox);
            }
            else if(map.get("Regenerate_Statistical_Coding_Flag").get(0).equalsIgnoreCase("No") || map.get("Regenerate_Statistical_Coding_Flag").get(0).equalsIgnoreCase("Uncheck"))
            {
                browserUtil.setsCheckBoxTo(false, rp_regeneratestatisticalcoding_CheckBox);
            }
            if(map.get("Regenerate_Policy_Writing_Flag").get(0).equalsIgnoreCase("Yes") || map.get("Regenerate_Policy_Writing_Flag").get(0).equalsIgnoreCase("Check"))
            {
                browserUtil.setsCheckBoxTo(true, rp_regeneratepolicywriting_CheckBox);
            }
            else if(map.get("Regenerate_Policy_Writing_Flag").get(0).equalsIgnoreCase("No") || map.get("Regenerate_Policy_Writing_Flag").get(0).equalsIgnoreCase("Uncheck"))
            {
                browserUtil.setsCheckBoxTo(false, rp_regeneratestatisticalcoding_CheckBox);
            }

            browserUtil.waitsUntilWebElementIsClickable(ip_Issue_Button);
            browserUtil.clicksWebElement(ip_Issue_Button);
            browserUtil.waitUntilPleaseWaitDisappear();
        }
        public void issuePolicyRateMode() throws InterruptedException
        {
            baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("ISSUE");
            //browserUtil.switchToFrame("InsDmain");
            browserUtil.clicksWebElement(ip_Issue_Button);
            browserUtil.waitUntilPleaseWaitDisappear();
        }

    }

    public Browser_Util theUser() {
        return this.browserUtil;
    }

    public Issue_Page.IssuePageMethods theUser_() {
        return this.pageMethods;
    }

}