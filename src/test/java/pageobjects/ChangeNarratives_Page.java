package pageobjects;

import org.openqa.selenium.By;
import utilities.Base_Util;
import utilities.Browser_Util;
import utilities.LogAndReport_Util;
import utilities.Screenshot_Util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ChangeNarratives_Page
{

    private Browser_Util browserUtil;
    private Base_Util baseUtil;
    private LogAndReport_Util log;
    private Screenshot_Util ss;
    private ChangeNarrativesMethods pageMethods;

    public ChangeNarratives_Page(LogAndReport_Util logAndReport, Screenshot_Util screenshot, Browser_Util browser_Util, Base_Util base_util)
    {
        this.browserUtil = browser_Util;
        this.baseUtil = base_util;
        this.log = logAndReport;
        this.ss = screenshot;
        this.pageMethods = new ChangeNarratives_Page.ChangeNarrativesMethods();
    }

    public interface IChangeNarratives
    {
        String page = "Change Narratives";

        List cnp_AddItem_Image = Arrays.asList(By.id("CoChangeNarratives_Grid_UIGridBaseNarr_cmdAddRowItem"), page, "'AddItem_Image'");
        List cnp_ChangeNarratives_DropDown = Arrays.asList(By.id("CoChangeNarratives_Grid_UIGridBaseNarr_ddTypeSortCd"), page, "'ChangeNarratives_DropDown'");
        List cnp_ChangeNarrativeDescription_TextBox = Arrays.asList(By.id("CoChangeNarrativesEdit_CoChangeNarrativeHTML_ActiveControl_CoChangeNarrative_NarrativeTx"), page, "'ChangeNarrativeDescription_TextBox'");
        List cnp_Save_Link = Arrays.asList(By.xpath("//li[@title='Save']/a[1]"), page, "'Save_Link'");
    }

    public class ChangeNarrativesMethods implements ChangeNarratives_Page.IChangeNarratives
    {
        public void AddsChangeNarrative(Map<String, List<String>> testDataAsMap)
        {
            List cnp_ChangeNarrative_Row;

            cnp_ChangeNarrative_Row = Arrays.asList(By.xpath("//div[@id='CoChangeNarratives_Grid_UIGridBaseNarr_UIGridBaseNarr']//table[@role='grid']//tr[./td[normalize-space()='" + testDataAsMap.get("ChangeNarrative").get(0) + "']]"), page, "'ChangeNarrative_Row' (" + testDataAsMap.get("ChangeNarrative").get(0) + ")");

            baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("CHANGE NARRATIVES");
            browserUtil.switchToDefaultContent();
            browserUtil.switchToFrame("InsDmain");
            browserUtil.switchToFrame("IFChangeNarrInfo");
            browserUtil.selectsValueFromDropDown(testDataAsMap.get("ChangeNarrative").get(0), cnp_ChangeNarratives_DropDown);
            browserUtil.clicksWebElement(cnp_AddItem_Image);
            browserUtil.switchToDefaultContent();
            browserUtil.switchToFrame("InsDmain");
            browserUtil.entersTextWithTabIn(cnp_ChangeNarrativeDescription_TextBox, testDataAsMap.get("ChangeNarrativeDescription").get(0));
            browserUtil.clicksWebElement(cnp_Save_Link);
            browserUtil.insertsHardCodedDelayInMilliSeconds(5000);
            browserUtil.switchToDefaultContent();
            browserUtil.switchToFrame("InsDmain");
            browserUtil.switchToFrame("IFChangeNarrInfo");
            /*
            if(browserUtil.verifiesWebElementIsPresent(cnp_ChangeNarrative_Row))
            {
                browserUtil.writesToLogAndReport("Pass", "Added change narrative '" + testDataAsMap.get("ChangeNarrative").get(0) + "' successfully.");
            }
            else
            {
                browserUtil.writesToLogAndReport("Fail", "Failed to add change narrative '" + testDataAsMap.get("ChangeNarrative").get(0) + "' successfully.");
            }
            */
        }
    }

    public Browser_Util theUser()
    {
        return this.browserUtil;
    }

    public ChangeNarrativesMethods theUser_()
    {
        return this.pageMethods;
    }

}