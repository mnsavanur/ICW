package pageobjects;

import org.openqa.selenium.By;
import utilities.Base_Util;
import utilities.Browser_Util;
import utilities.LogAndReport_Util;
import utilities.Screenshot_Util;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class Names_Page {
    private Base_Util baseUtil;
    private Browser_Util browserUtil;
    private LogAndReport_Util log;
    private Screenshot_Util ss;
    private Names_Page.NamesMethods pageMethods;

    public Names_Page(LogAndReport_Util logAndReport, Screenshot_Util screenshot, Browser_Util browser_Util, Base_Util base_util) {
        this.browserUtil = browser_Util;
        this.baseUtil = base_util;
        this.log = logAndReport;
        this.ss = screenshot;
        this.pageMethods = new Names_Page.NamesMethods();
    }

    public interface INames {
        List np_name_link = Arrays.asList(By.xpath("//a[@id='dgEntNameList_LegalEntityNm_0']"), "Names Page", "Names Link");
        List np_name_text = Arrays.asList(By.id("WkEntityNameDetailHTML_WkLegalEntityName_LegalEntityNm"), "Names Page", "Names Link");

    }

    public class NamesMethods implements Names_Page.INames{

        public void updateNamesTxt(Map<String, String> map) throws InterruptedException
        {
            String namesTxt = map.get("namesTxt");
            baseUtil.navigatesToSpecifiedLinkOnPolicyExplorer("NAMES");
            browserUtil.waitUntilPleaseWaitDisappear();
            //browserUtil.switchToDefaultContent();
            //browserUtil.switchToFrame("InsDmain");
            //browserUtil.switchToFrame("IFEntity");
            browserUtil.clicksWebElement(np_name_link);
            browserUtil.waitUntilPleaseWaitDisappear();
            //browserUtil.switchToDefaultContent();
            //browserUtil.switchToFrame("InsDmain");
            browserUtil.entersTextWithTabIn(np_name_text, namesTxt);
        }
    }

    public Browser_Util theUser() {
        return this.browserUtil;
    }

    public Names_Page.NamesMethods theUser_() {
        return this.pageMethods;
    }

}