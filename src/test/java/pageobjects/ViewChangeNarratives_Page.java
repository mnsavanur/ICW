package pageobjects;

import org.openqa.selenium.By;
import utilities.Base_Util;
import utilities.Browser_Util;
import utilities.LogAndReport_Util;
import utilities.Screenshot_Util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ViewChangeNarratives_Page
{

    private Browser_Util browserUtil;
    private Base_Util baseUtil;
    private LogAndReport_Util log;
    private Screenshot_Util ss;
    private ViewChangeNarrativesMethods pageMethods;

    public ViewChangeNarratives_Page(LogAndReport_Util logAndReport, Screenshot_Util screenshot, Browser_Util browser_Util, Base_Util base_util)
    {
        this.browserUtil = browser_Util;
        this.baseUtil = base_util;
        this.log = logAndReport;
        this.ss = screenshot;
        this.pageMethods = new ViewChangeNarratives_Page.ViewChangeNarrativesMethods();
    }

    public interface IViewChangeNarratives
    {
        String page = "View Change Narratives";

        List cvnp_ChangeNarrative_Label = Arrays.asList(By.xpath("//div[@class='monospace']"), page, "'ChangeNarrative_Label'");
        List cvnp_Cancel_Link = Arrays.asList(By.xpath("//a[@class='igdm_MenuItemHorizontalRootLink ' and contains(normalize-space(),'Cancel')]"), page, "'Cancel_Link'");
    }

    public class ViewChangeNarrativesMethods implements ViewChangeNarratives_Page.IViewChangeNarratives
    {
        public void verifiesChangeNarrative(Map<String, List<String>> testDataAsMap)
        {
            String actualChangeNarrativeText;
            String expectedChangeNarrativeText;

            browserUtil.switchToDefaultContent();
            browserUtil.switchToFrame("InsDmain");
            browserUtil.switchToFrame("idWorksheet");

            actualChangeNarrativeText = browserUtil.getsTextOfWebElement(cvnp_ChangeNarrative_Label).trim();
            actualChangeNarrativeText = actualChangeNarrativeText.replace(" ", "");
            actualChangeNarrativeText = actualChangeNarrativeText.replace("\u00A0", "");
            actualChangeNarrativeText = actualChangeNarrativeText.replace("\n", "");
            actualChangeNarrativeText = actualChangeNarrativeText.replace("\r", "");

            expectedChangeNarrativeText = testDataAsMap.get("ChangeNarrativeDescription").get(0).toUpperCase().trim();
            expectedChangeNarrativeText = expectedChangeNarrativeText.replace(" ", "");
            expectedChangeNarrativeText = expectedChangeNarrativeText.replace("\u00A0", "");
            expectedChangeNarrativeText = expectedChangeNarrativeText.replace("\n", "");
            expectedChangeNarrativeText = expectedChangeNarrativeText.replace("\r", "");

            if(actualChangeNarrativeText.contains(expectedChangeNarrativeText))
            {
                browserUtil.writesToLogAndReport("Pass", "Change narrative description '" + testDataAsMap.get("ChangeNarrativeDescription").get(0) + "' present.");
            }
            else
            {
                browserUtil.writesToLogAndReport("Fail", "Change narrative description '" + testDataAsMap.get("ChangeNarrativeDescription").get(0) + "' not present.");
            }
            browserUtil.switchToDefaultContent();
            browserUtil.switchToFrame("InsDmain");
            browserUtil.clicksWebElement(cvnp_Cancel_Link);
        }
    }

    public Browser_Util theUser()
    {
        return this.browserUtil;
    }

    public ViewChangeNarrativesMethods theUser_()
    {
        return this.pageMethods;
    }

}